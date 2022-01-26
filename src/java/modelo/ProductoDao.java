package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDao extends Conexion {

    PreparedStatement ps;
    ResultSet rs;
    Connection con = null;

    //Registrar Producto
    public boolean registrar(Producto pro) {
        String sql = "insert into producto1(id,marca,modelo,color,precio,cuota)values(?,?,?,?,?,?)";
        try {
            con = getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, pro.getId());
            ps.setString(2, pro.getMarca());
            ps.setString(3, pro.getModelo());
            ps.setString(4, pro.getColor());
            ps.setDouble(5, pro.getPrecio());
            ps.setDouble(6, pro.getCuota());
            ps.execute();
            con.close();
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    //Listar Productos
    public List<Producto> listar() {
        List<Producto> list = new ArrayList();
        String sql = "select * from producto1";
        try {
            con = getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                String color = rs.getString("color");
                double precio = rs.getDouble("precio");
                double cuota = rs.getDouble("cuota");
                Producto pro = new Producto(id, marca, modelo, color, precio, cuota);
                list.add(pro);
            }
            con.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return list;
    }
}
