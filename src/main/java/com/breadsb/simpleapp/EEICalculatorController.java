package com.breadsb.simpleapp;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Font;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;
import java.time.LocalDateTime;

public class EEICalculatorController {
    public TextField nominalEfficiencyField;
    public TextField biomassCoefficientField;
    public TextField parameterF2Field;
    public Label eeiLabel;
    public Label energeticEfficiencyClass;
    public Button generatePDFButton;
    public Label productNameField;
    Calculations calculations = new Calculations();
    private boolean isEEICalculated = false;

    @FXML
    protected void onCalculateButtonClick() {
        try {
            double result = calculations.calculateEEIValueFromTextField(nominalEfficiencyField, biomassCoefficientField, parameterF2Field);
            eeiLabel.setText( String.format("%.2f", result) );
            EnergeticClass eec = calculations.checkEnergeticEfficiencyClass(result);
            changeStyleOfEnergeticEfficiencyClass(eec, eec.getColorCode());
            enablePDFButton();
        } catch (NumberFormatException | EnergeticClassException ece) {
            eeiLabel.setText("Wrong input value");
            createAndShowAlert("Input values must be numeric and not empty!\n" +
                    "Please fill proper values in fields");
        }
    }

    private void enablePDFButton() {
        generatePDFButton.setDisable(false);
        generatePDFButton.setOnMouseClicked(event -> {
            onGeneratePDFButtonClick();
        });
    }

    private void changeStyleOfEnergeticEfficiencyClass(EnergeticClass eec, String colour) {
        energeticEfficiencyClass.setText(eec.getEnergeticClass());
        energeticEfficiencyClass.getStyleClass().clear();
        energeticEfficiencyClass.setStyle("-fx-background-color: " + colour + "; -fx-text-fill: white;");
    }

    private void createAndShowAlert(String text) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(text);
        alert.showAndWait();
    }

    private void onGeneratePDFButtonClick() {
        if(!productNameField.getText().isBlank()) {
            generatePDF();
        } else {
            createAndShowAlert("Product name is empty. Please fill field");
        }
//        Generate PDF
    }

    private void generatePDF() {
        LocalDateTime ldt = LocalDateTime.now();
        try (PDDocument document = new PDDocument()) {
            PDPage blankPage = new PDPage();
            document.addPage(blankPage);

            PDPageContentStream stream = new PDPageContentStream(document, blankPage);
            stream.setFont(PDType1Font.COURIER, 12);
            stream.beginText();
            stream.showText("Product name: " + productNameField.getText());
            stream.showText("Energetic efficiency index: " + eeiLabel.getText());
            stream.showText("Report published: " + ldt);
            stream.endText();
            stream.close();
            document.save("eei_report.pdf");
            document.close();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Raport generated at: " + document.getDocumentInformation());
            alert.showAndWait();
        } catch (Exception e) {
            createAndShowAlert("Error");
            System.out.println("Check at: " + e.getMessage());
        }
    }
}