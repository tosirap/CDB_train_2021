package dao;

import modele.Company;
import modele.Computer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOCompany extends  DAO<Company> {

    Connection connection = null;

    public DAOCompany() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean create(Company company) {

        // TODO Auto-generated method stub
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO COMPANY(id ,name) "
                    + "VALUES (NULL , ?, ?,?,?)");
            preparedStatement.setString(1,  company.getName());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        // TODO Auto-generated method stub
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM COMPANY WHERE name = " + id + ";");
            preparedStatement.executeUpdate();
            return true;
        }
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Company company) {
        return false;
    }

    @Override
    public Company find(int id) {
        // TODO Auto-generated method stub
        Company comp = new Company();
        try {
            ResultSet result = this.connect
                    .createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
                    .executeQuery("SELECT * FROM COMPANY WHERE id = " + id);
            if (result.first())
                comp = new Company(id, result.getString("name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comp;
    }

    public ArrayList<Company> findAll() {
        ArrayList<Company> retAL = new ArrayList<Company>();
        Company tmp;
        try{
            ResultSet result = super.connect.createStatement().executeQuery("SELECT * FROM company");
            while(result.next()) {
                tmp = new Company(result.getInt("id"), result.getString("name"));
                retAL.add(tmp);
            }

        }catch(SQLException e) {
            e.printStackTrace();
        }

        return retAL;
    }
}
