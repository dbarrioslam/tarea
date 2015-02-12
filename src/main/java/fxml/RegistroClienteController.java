/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import clases.Persona;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author daniel.barrios
 */
public class RegistroClienteController implements Initializable {

    @FXML
    private TextField tfNombreCliente;
    @FXML
    private TextField tfApePatCliente;
    @FXML
    private DatePicker tfFecNacCliente;
    @FXML
    private TextField tfApeMatCliente;
    @FXML
    private Button btnCancelarCliente;
    @FXML
    private Button btnGuardarCliente;
    @FXML
    private TextField tfdniCliente;

    String nomCliente;
    String apePatCliente;
    String apeMatCliente;
    String dniCliente;
    LocalDate fecNacCliente;
    Persona cliente;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void cancelarCliente(ActionEvent event) {
        Stage stage = (Stage) btnCancelarCliente.getScene().getWindow();
        // do what you have to do
        stage.close();

    }

    @FXML
    private void guardarCliente(ActionEvent event) {

        nomCliente = tfNombreCliente.getText();
        apePatCliente = tfApePatCliente.getText();
        apeMatCliente = tfApeMatCliente.getText();
        dniCliente = tfdniCliente.getText();
        fecNacCliente = tfFecNacCliente.getValue();
        

        cliente = new Persona(nomCliente, apePatCliente, apeMatCliente, fecNacCliente,dniCliente);

        try {
            cliente.guardarCliente();
        } catch (Exception e) {

        }
        //cliente.guardarCliente(nomCliente, apePatCliente, apeMatCliente, fecNacCliente);
        //conexion11 cone1=new conexion11();
        //cone1.ejecutar("insert into cliente(nombreCliente,apellidoPaterno,apellidoMaterno,fechaNacimiento) values ('1','1','1','1995-02-11')");
    }

}
