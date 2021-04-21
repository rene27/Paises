package com.emergentes.controlador;

import com.emergentes.modelo.Contacto;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/bd_ejercicio";
        String usuario = "root";
        String password = "";
        
        Connection conn = null;
        String sql = "";
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        ArrayList<Contacto> lista = new ArrayList<Contacto>();
         
        
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuario, password);
            sql = "select * from ciudades";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Contacto c = new Contacto();
                c.setId(rs.getInt("id"));
                c.setNombre(rs.getString("nombre"));
                c.setCapital(rs.getString("capital"));
                c.setHabitantes(rs.getInt("habitantes"));
                c.toString();
                lista.add(c);
            }
            
            request.setAttribute("lista", lista);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (ClassNotFoundException e){
            System.out.println("Error en driver" + e.getMessage());
        } catch (SQLException e){
            System.out.println("Error al conectar" + e.getMessage());
        }    
    }
}
