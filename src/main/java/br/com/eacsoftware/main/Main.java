package br.com.eacsoftware.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import br.com.eacsoftware.howamiws.beans.Registro;
import br.com.eacsoftware.howamiws.dao.ParametrosDAO;

public class Main {

  public static void main(String[] args) {
    Connection con = null;
    // Statement stmt = null;
    List<Registro> registros = null;
    try {
      Class.forName("com.mysql.jdbc.Driver");
      String DB_URL = "jdbc:mysql://localhost/sqldados";
      String USER = "root";
      String PASS = "root";
      System.out.println("Connecting to database...");
      con = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Creating statement...");
      // stmt = con.createStatement();
      System.out.println("Conectando ao banco...");
      System.out.println("Conectado.");
    } catch (ClassNotFoundException ex) {
      System.out.println("Classe não encontrada, adicione o driver nas bibliotecas.");
    } catch (SQLException e) {
      System.out.println(e);
      throw new RuntimeException(e);
    }
    try {
      registros = ParametrosDAO.listaRgistrosDiaModulo(con, "1");
      if (registros != null) {
        for (Registro registro : registros) {
          System.out.println(registro.getData());
        }
      }
      System.out.println();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
