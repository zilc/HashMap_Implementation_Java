package edu.ktu.ds.lab3.cepkauskas;

import edu.ktu.ds.lab3.cepkauskas.ManualTest;
import edu.ktu.ds.lab3.gui.MainWindowCapacitor;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Locale;

/*
 * Darbo atlikimo tvarka - čia yra pradinė klasė.
 */
public class DemoExecutionCapacitor extends Application {

    public static void main(String[] args) {
        DemoExecutionCapacitor.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Locale.setDefault(Locale.US); // Suvienodiname skaičių formatus 
        //ManualTest.executeTest();
        setUserAgentStylesheet(STYLESHEET_MODENA);    //Nauja FX išvaizda
        //setUserAgentStylesheet(STYLESHEET_CASPIAN); //Sena FX išvaizda
        MainWindowCapacitor.createAndShowGui(primaryStage);
    }
}
