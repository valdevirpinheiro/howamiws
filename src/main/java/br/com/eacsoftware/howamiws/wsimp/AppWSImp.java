package br.com.eacsoftware.howamiws.wsimp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.jws.WebService;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import br.com.eacsoftware.howamiws.beans.Registro;
import br.com.eacsoftware.howamiws.dao.ParametrosDAO;
import br.com.eacsoftware.howamiws.interfaces.AppWS;

@WebService(endpointInterface = "br.com.eacsoftware.howamiws.interfaces.AppWS")
public class AppWSImp implements AppWS {

	public String sayHi(String text) {
		return "Hello " + text;
	}

	public List<Registro> listaRgistrosDiaModulo(String funcionario) {
		// RespostaListaParametrosModulo resposta = new
		// RespostaListaParametrosModulo();
		// resposta.setSucesso(false);
		// funcionario = "1";
		List<Registro> regs = null;
		Connection con;
		try {
			try {
				con = conectaBanco();
				regs = ParametrosDAO.listaRgistrosDiaModulo(con, funcionario);
				con.close();
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Parametros parametros = ParametrosDAO.listaParametrosModulo(con,
			// modulo, processo, terminal, atividade);
			// resposta.setSucesso(true);
			// resposta.setParametros(parametros);
			// JAXBContext context =
			// JAXBContext.newInstance("br.com.eacsoftware.saciws.tipos");
			// Marshaller marshaller = context.createMarshaller();
			// marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			// StringWriter sw = new StringWriter();
			// marshaller.marshal(resposta, sw);
			return regs;
		} catch (SQLException e) {
			// return e.getMessage();
		}
		return regs;
	}

	private Connection conectaBanco() throws NamingException, SQLException {
		// Context ctx;
		// ctx = new InitialContext();
		// DataSource ds = (DataSource)
		// ctx.lookup("java:comp/env/jdbc/howamieac");
		// return ds.getConnection();
		// TODO Auto-generated catch block
		try {
			Connection con = null;
			// Statement stmt = null;
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
			return con;
		} catch (ClassNotFoundException ex) {
			System.out.println("Classe não encontrada, adicione o driver nas bibliotecas.");
		} catch (SQLException e) {
			System.out.println(e);
			throw new RuntimeException(e);
		}
		return null;
	}
}
