package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LineaModel extends LineaClass{
	ArrayList<LineaModel> list = new ArrayList<LineaModel>();

	public LineaModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LineaModel(int id_linea, int id_producto, double precio) {
		super(id_linea, id_producto, precio);
		// TODO Auto-generated constructor stub
	}

	public LineaModel(ArrayList<LineaModel> list) {
		super();
		this.list = list;
	}

	public ArrayList<LineaModel> getList() {
		return list;
	}

	public void setList(ArrayList<LineaModel> list) {
		this.list = list;
	}
	
	public void LoadData() throws SQLException {
		
		this.CreateConection();
		
		Statement st = this.con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM `producto`");

		while (rs.next()) { // reads the table line by line

			LineaModel myLinea = new LineaModel();
			myLinea.setId_linea(Integer.parseInt(rs.getString(1)));
			myLinea.setId_producto(Integer.parseInt(rs.getString(2)));
			myLinea.setPrecio(Double.parseDouble(rs.getString(3)));
			
			this.list.add(myLinea);
		}
		this.disconnect();
	}
	//prueba
}