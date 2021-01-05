package com.svalero.aplicacion.modelos;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.svalero.aplicacion.clases.Moto;
import org.bson.Document;

import java.sql.*;
import java.util.ArrayList;


public class MotoDAO {

    private static final String NOMBRE_DB = "motos";

    private Connection conexion;
    private MongoClient mongoClient;
    private MongoDatabase db;


    public void conectar() {
        mongoClient = new MongoClient();
        db = mongoClient.getDatabase(NOMBRE_DB);
    }


    public void desconectar () {
        mongoClient.close();
    }



//    public ArrayList<Moto> getListaMotos() {
//
//    }


    public void guardarMoto(Moto moto) {

        Document documento = new Document()
                .append("matricula", moto.getMatricula())
                .append("marca", moto.getMarca())
                .append("modelo", moto.getModelo())
                .append("tipo", moto.getTipo());

        db.getCollection(NOMBRE_DB).insertOne(documento);

        System.out.println("Moto guardada correctamente");

    }



    public void eliminarMoto(Moto moto) {


    }


    public void modificarMoto(Moto motoAntigua, Moto motoNueva) throws SQLException {



    }



}
