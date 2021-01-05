package com.svalero.aplicacion.controladores;

import com.svalero.aplicacion.clases.Moto;
import com.svalero.aplicacion.modelos.MotoDAO;
import com.svalero.aplicacion.utilidades.Alertas;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.lang.reflect.Field;
import java.net.URL;
import java.util.ResourceBundle;

public class AppControlador implements Initializable {

    public Button btNueva, btGuardar, btCancelar, btModificar, btEliminar;
    public TextField tfMatricula, tfMarca, tfModelo;
    public ComboBox<String> cbTipo;
    public TableView tvMotos;

    private MotoDAO motoDAO;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        motoDAO = new MotoDAO();
        motoDAO.conectar();
        fijarColumnasTabla();
    }


    @FXML
    public void nuevaMoto(Event event) {
        Alertas.mostrarError("Hola Mundo!");
    }

    @FXML
    public void guardarMoto(Event event) {

        String matricula = tfMatricula.getText();
        String marca = tfMarca.getText();
        String modelo = tfModelo.getText();
        String tipo = cbTipo.getSelectionModel().getSelectedItem();

        Moto moto = new Moto(matricula, marca, modelo, tipo);
        motoDAO.guardarMoto(moto);

    }

    @FXML
    public void cancelar(Event event) {
        System.out.println("Hola Mundo");
    }

    @FXML
    public void modificarMoto(Event event) {
        System.out.println("Hola Mundo");
    }

    @FXML
    public void eliminarMoto(Event event) {
        System.out.println("Hola Mundo");
    }



    /* METODOS DE CLASE */


    /**
     * Se encarga definir las columnas del tableView de motos con los atributos de la clase Moto
     */
    private void fijarColumnasTabla() {

        Field[] fields = Moto.class.getDeclaredFields();

        for (Field field : fields) {

            if (field.getName().equals("id") || field.getName().equals("motoRecuperar"))
                continue;

            TableColumn<Moto, String> column = new TableColumn<>(field.getName());
            column.setCellValueFactory(new PropertyValueFactory<>(field.getName()));
            tvMotos.getColumns().add(column);

        }

        tvMotos.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

    }

}
