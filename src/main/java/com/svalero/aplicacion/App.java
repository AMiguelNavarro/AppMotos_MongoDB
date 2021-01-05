package com.svalero.aplicacion;

import com.svalero.aplicacion.controladores.AppControlador;
import com.svalero.aplicacion.utilidades.R;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {


    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader();
        AppControlador controlador = new AppControlador();

        loader.setLocation(R.getURL("inicio.fxml"));
        loader.setController(controlador);

        Parent root = loader.load();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    @Override
    public void init() throws Exception {
        super.init();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }


    public static void main (String [] args) {
        launch();
    }

}
