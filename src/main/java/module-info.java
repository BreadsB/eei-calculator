module com.breadsb.simpleapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires org.apache.pdfbox;
    requires java.desktop;

    opens com.breadsb.simpleapp to javafx.fxml;
    exports com.breadsb.simpleapp;
}