/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import fxml.conexion11;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author daniel.barrios
 */
public class Persona {

    String nombrePersona;
    String apePatPersona;
    String apeMatPersona;
    String dniPersona;

    LocalDate fecNacPersona;
    conexion11 cone;
    ResultSet rs;

    public Persona(String nombrePersona, String apePatPersona, String apeMatPersona, LocalDate fecNacPersona, String dniCliente) {
        this.nombrePersona = nombrePersona;
        this.apePatPersona = apePatPersona;
        this.apeMatPersona = apeMatPersona;
        this.fecNacPersona = fecNacPersona;
        this.dniPersona = dniCliente;

    }
    
    public Persona(){
        
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getApePatPersona() {
        return apePatPersona;
    }

    public void setApePatPersona(String apePatPersona) {
        this.apePatPersona = apePatPersona;
    }

    public String getApeMatPersona() {
        return apeMatPersona;
    }

    public void setApeMatPersona(String apeMatPersona) {
        this.apeMatPersona = apeMatPersona;
    }

    public String getDniPersona() {
        return dniPersona;
    }

    public void setDniPersona(String dniPersona) {
        this.dniPersona = dniPersona;
    }

    public LocalDate getFecNacPersona() {
        return fecNacPersona;
    }

    public void setFecNacPersona(LocalDate fecNacPersona) {
        this.fecNacPersona = fecNacPersona;
    }

    public void guardarCliente(String nombrePersona, String apePatPersona, String apeMatPersona, LocalDate fecNacPersona, String dniCliente) throws ClassNotFoundException, SQLException {

        try {
            conexion11 cone = new conexion11();
            cone.ejecutar("insert into cliente(nombreCliente,apellidoPaterno,apellidoMaterno,fechaNacimiento,DNI) values ('" + nombrePersona + "','" + apePatPersona + "','" + apeMatPersona + "','" + fecNacPersona + "','" + dniCliente + "')");

        } catch (Exception e) {

        }
    }

    public void guardarCliente() throws ClassNotFoundException, SQLException {

        try {
            cone = new conexion11();
            cone.ejecutar("insert into cliente(nombreCliente,apellidoPaterno,apellidoMaterno,fechaNacimiento,DNI) values ('" + this.nombrePersona + "','" + this.apePatPersona + "','" + this.apeMatPersona + "','" + this.fecNacPersona + "','" + this.dniPersona + "')");

        } catch (Exception e) {

        }
    }

    public void modificarCliente(String nombrePersona, String apePatPersona, String apeMatPersona, LocalDate fecNacPersona, String dniPersona, String dniAntiguoPersona) {

        try {
            cone = new conexion11();
            cone.ejecutar("update cliente set nombreCliente='"+nombrePersona+"',apellidoPaterno='"+apePatPersona+"',apellidoMaterno='"+apeMatPersona+"',fechaNacimiento='"+fecNacPersona+"',DNI='"+dniPersona+"' where DNI='"+dniAntiguoPersona+"' ");

        } catch (Exception e) {

        }
    }

    public boolean buscarCliente(String DNICliente) {
        
        boolean hayCliente = false;
        try {
            cone = new conexion11();
            rs = cone.consulta("select * from cliente where DNI='"+DNICliente+"' ");
            
            
            hayCliente = rs.next();
            
                       
            
            
        } catch (Exception e) {
            
        }
        return hayCliente;
    }
    
    public ResultSet obtenerCliente(String DNICliente){
        
        try {
            cone = new conexion11();
            rs = cone.consulta("select * from cliente where DNI='"+DNICliente+"' ");
                   
            rs.next();
            
                       
            
            
        } catch (Exception e) {
            
        }
        
        return rs;
        
    }
    
    

}
