package org.gutierrez.carmona.alonso.Jdbc;

import org.gutierrez.carmona.alonso.consola.Conexion;
import org.gutierrez.carmona.alonso.model.normal.GeneroMusical;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GeneroMusicalJdbcImpl extends Conexion<GeneroMusical> implements GeneroMusicalJdbc
{
    private static GeneroMusicalJdbc generoMusicalJdbc;

    public GeneroMusicalJdbcImpl() {}

    public static GeneroMusicalJdbc getInstance()
    {
        if(generoMusicalJdbc ==null)
        {
            generoMusicalJdbc =new GeneroMusicalJdbcImpl();
        }
        return generoMusicalJdbc;
    }

    @Override
    public List<GeneroMusical> findAll() {
        Statement statement = null;
        ResultSet resultSet = null;
        List<GeneroMusical> generos = null;
        GeneroMusical generoMusical = null;
        String query = "SELECT * FROM GENERO_MUSICAL";

        try {
            if (!openConnection()) {
                System.out.println("Error en la conexion");
                return null;
            }
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            generos = new ArrayList<>();
            while (resultSet.next()) {
                generoMusical = new GeneroMusical();
                generoMusical.setId(resultSet.getInt(1));
                generoMusical.setDescripcion(resultSet.getString(2));
                generos.add(generoMusical);
            }
            resultSet.close();
            statement.close();
            closeConnection();
            return generos;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean save(GeneroMusical generoMusical) {
        int res = 0;
        PreparedStatement preparedStatement = null;
        String query = "INSERT INTO GENERO_MUSICAL (descripcion) values (?);";
        try {
            if (!openConnection()) {
                System.out.println("Error en la conexion");
                return false;
            }
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, generoMusical.getDescripcion());
            res = preparedStatement.executeUpdate();
            preparedStatement.close();
            closeConnection();
            return res == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(GeneroMusical generoMusical) {
        int res=0;
        PreparedStatement preparedStatement=null;
        String query="UPDATE GENERO_MUSICAL SET DESCRIPCION=? WHERE ID=?;";
        try {
            if (!openConnection())
            {
                System.out.println("Error en la conexion");
                return false;
            }
            preparedStatement= connection.prepareStatement(query);
            preparedStatement.setString(1,generoMusical.getDescripcion());
            preparedStatement.setInt(2,generoMusical.getId());
            res=preparedStatement.executeUpdate();
            preparedStatement.close();
            closeConnection();
            return res==1;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(GeneroMusical generoMusical) {
        int res=0;
        PreparedStatement preparedStatement=null;
        String query="DELETE FROM GENERO_MUSICAL WHERE ID = ?";
        try {
            if(!openConnection()) {
                System.out.println("Error en la conexion");
                return false;
            }
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, generoMusical.getId());
            res = preparedStatement.executeUpdate();
            preparedStatement.close();
            closeConnection();
            return res == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public GeneroMusical findById(Integer id) {
        Statement statement=null;
        ResultSet resultSet=null;
        List<GeneroMusical>generos=null;
        GeneroMusical genero=null;
        String query="SELECT * FROM GENERO_MUSICAL WHERE ID=%d";

        try
        {
            if (!openConnection())
            {
                System.out.println("Error en conexion");
                return null;
            }
            query=String.format(query, id);
            statement= connection.createStatement();
            resultSet=statement.executeQuery(query);
            generos=new ArrayList<>();
            if (resultSet.next())
            {
                genero=new GeneroMusical();
                genero.setId(resultSet.getInt(1));
                genero.setDescripcion(resultSet.getString(2));
                generos.add(genero);
            }
            resultSet.close();
            statement.close();
            closeConnection();
            return genero;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}