/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import clases.Persona;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author daniel.barrios
 */
public class ActualizacionClienteController implements Initializable {

    @FXML
    private TextField tfBuscarDniCliente;
    @FXML
    private Button btnBuscarCliente;
    @FXML
    private Button btnCancelarCliente;
    @FXML
    private Pane panelDatos;
    @FXML
    private TextField tfApePatCliente;
    @FXML
    private DatePicker tfFecNacCliente;
    @FXML
    private TextField tfdniCliente;
    @FXML
    private TextField tfApeMatCliente;
    @FXML
    private Button btnGuardarCliente;
    @FXML
    private TextField tfNombreCliente;

    String DniBusquedaCliente;
    Persona cliente;
    ResultSet rs;
    String nombrePersona;
    String apePatPersona;
    String apeMatPersona;
    String dniPersona;

    LocalDate fecNacPersona;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        panelDatos.setVisible(false);
        btnGuardarCliente.setVisible(false);

    }

    @FXML
    private void buscarCliente(ActionEvent event) throws SQLException {

        DniBusquedaCliente = tfBuscarDniCliente.getText();
        cliente = new Persona();
        boolean hayCliente = cliente.buscarCliente(DniBusquedaCliente);

        if (hayCliente) {
            JOptionPane.showMessageDialog(null, "Se encontró un cliente con el DNI:" + DniBusquedaCliente);
            panelDatos.setVisible(true);
            btnGuardarCliente.setVisible(true);
            rs = cliente.obtenerCliente(DniBusquedaCliente);
            tfNombreCliente.setText(rs.getString(2));
            tfApePatCliente.setText(rs.getString(3));
            tfApeMatCliente.setText(rs.getString(4));
            tfdniCliente.setText(rs.getString(6));
            tfFecNacCliente.setValue(rs.getDate(5).toLocalDate());


        } else {
            JOptionPane.showMessageDialog(null, "No hay cliente con ese DNI");
        }
    }

    @FXML
    private void cancelarCliente(ActionEvent event) {
        Stage stage = (Stage) btnCancelarCliente.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    @FXML
    private void guardarCliente(ActionEvent event) {
        modificarCliente();
    }

    private void modificarCliente() {
        nombrePersona=tfNombreCliente.getText();
        apePatPersona=tfApePatCliente.getText();
        apeMatPersona=tfApeMatCliente.getText();
        dniPersona=tfdniCliente.getText();
        fecNacPersona=tfFecNacCliente.getValue();
        
        cliente = new Persona(nombrePersona, apePatPersona, apeMatPersona, fecNacPersona, dniPersona);
        cliente.modificarCliente(nombrePersona, apePatPersona, apeMatPersona, fecNacPersona, dniPersona,DniBusquedaCliente);
        JOptionPane.showMessageDialog(null, "Los datos del cliente han sido modificados satisfactoriamente");
    }
}
