module com.breadsb.eeicalculator {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires org.apache.pdfbox;

    opens com.breadsb.eeicalculator to javafx.fxml;
    exports com.breadsb.eeicalculator;
}