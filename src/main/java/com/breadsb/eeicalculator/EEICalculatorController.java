package com.breadsb.eeicalculator;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.awt.Desktop;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

public class EEICalculatorController {
    public TextField nominalEfficiencyField;
    public TextField biomassCoefficientField;
    public TextField parameterF2Field;
    public Label eeiLabel;
    public Label energeticEfficiencyClass;
    public Button generatePDFButton;
    public TextField productNameField;
    Calculations calculations = new Calculations();

    @FXML
    protected void onCalculateButtonClick() {
        try {
            double result = calculations.calculateEEIValueFromTextField(nominalEfficiencyField, biomassCoefficientField, parameterF2Field);
            eeiLabel.setText(String.format("%.2f", result));
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
        if (!productNameField.getText().isBlank()) {
            generatePDF();
        } else {
            createAndShowAlert("Product name is empty. Please fill field");
        }
    }

    private void generatePDF() {
        LocalDateTime ldt = LocalDateTime.now();
        try (PDDocument document = new PDDocument()) {
            PDPage blankPage = new PDPage();
            document.addPage(blankPage);
            File file = new File("eei_report.pdf");

            PDPageContentStream stream = new PDPageContentStream(document, blankPage);
            textInPDF(stream, "Product name: " + productNameField.getText(), "Energetic efficiency index: " + eeiLabel.getText(), "Report published: " + ldt);
            document.save(file);
            document.close();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Raport generated at: " + document.getDocumentInformation());
            alert.showAndWait();
            Desktop desktop = Desktop.getDesktop();
            desktop.open(file);
        } catch (Exception e) {
            createAndShowAlert("Error at generating PDF");
            System.out.println("Check at: " + e.getMessage());
        }
    }

    private void textInPDF(PDPageContentStream pdPageContentStream, String... args) {
        try {
            pdPageContentStream.beginText();
            pdPageContentStream.setFont(PDType1Font.COURIER, 12);
            pdPageContentStream.setLeading(45);
            pdPageContentStream.newLineAtOffset(50, 700);

            for (String text : args) {
                pdPageContentStream.showText(text);
                pdPageContentStream.newLine();
            }
            pdPageContentStream.endText();
            pdPageContentStream.close();
        } catch (IOException e) {
            createAndShowAlert("No text");
        }
    }
}
