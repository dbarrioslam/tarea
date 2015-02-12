/*Proyecto realizado por: Alejandro Hurtado C.
 estudiante de la EAPIIS-UNAMBA 7mo S.  
 proteccion compartida por el Autor sepais valorar
 el conocimiento es libre:
 mas Videotutoriales en:http://www.portaltutoriales.com/
 Created on 13-feb-2012, 10:42:56
 */
package fxml;

import java.sql.*;

public class conexion11 {

    Connection conectar;
    Statement stSentenciasSQL;
    ResultSet rsDatosResultado;
    PreparedStatement psPrepararSentencia;

    public conexion11() throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cine";
            conectar = DriverManager.getConnection(url, "root", "root");
            stSentenciasSQL = conectar.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (ClassNotFoundException ex) {
            throw ex;
        } catch (SQLException ex1) {
            throw ex1;
        }
    }

    //funcion para ejecutar sentencias SELECT

    public ResultSet consulta(String sql) throws SQLException {
        try {
            rsDatosResultado = stSentenciasSQL.executeQuery(sql);//para sentencias select nada mas

        } catch (SQLException ex) {
            throw ex;
        }
        return rsDatosResultado;
    }
    //funcion para ejecutar sentencias INSERT DELETE UPDATE

    public void ejecutar(String sql) throws SQLException {
        try {
            stSentenciasSQL.execute(sql);
        } catch (SQLException ex) {
            throw ex;
        }
    }
}
