package com.svalero.aplicacion.utilidades;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class Alertas {

    public static void mostrarError(String mensajeError) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("ERROR");
        alerta.setContentText(mensajeError);
        alerta.showAndWait();
    }


    public static Optional<ButtonType> mostrarConfirmación() {

        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Confirmación");
        alerta.setContentText("¿Estás seguro?");
        Optional<ButtonType> respuesta = alerta.showAndWait();

        return respuesta;

    }

}
