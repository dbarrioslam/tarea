/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

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

    String nomCliente;
    String apePatCliente;
    String apeMatCliente;
    LocalDate fecNacCliente;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void cancelarCliente(ActionEvent event) {
    }

    @FXML
    private void guardarCliente(ActionEvent event) {
        
        nomCliente = tfNombreCliente.getText();
        apePatCliente = tfApePatCliente.getText();
        apeMatCliente = tfApeMatCliente.getText();
       
        fecNacCliente = tfFecNacCliente.getValue();
        System.out.println("la feccha es "+fecNacCliente);
    }
    
}
