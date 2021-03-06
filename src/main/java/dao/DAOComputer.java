package dao;

import modele.Computer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class DAOComputer extends DAO<Computer> {

    Connection connection = null;

    public DAOComputer() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean create(Computer computer) {
        // TODO Auto-generated method stub
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO computer(id ,name, introduced, discontinued, company_id) "
                    + "VALUES (NULL , ?, ?,?,?)");
            preparedStatement.setString(1,  computer.getName());
            preparedStatement.setString(2,  String.valueOf(computer.getIntroduced()));
            preparedStatement.setString(3,  String.valueOf(computer.getDiscontinued()));
            preparedStatement.setString(4,  String.valueOf(computer.getCompanyId()));
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
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM computer WHERE name = " + id + ";");
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
    public boolean update(Computer computer) {
        // TODO Auto-generated method stub
        return false;
    }

    public ArrayList<Computer> findAll(){
        ArrayList<Computer> retAL = new ArrayList<Computer>();
        Computer tmp;
        try{
            ResultSet result = super.connect.createStatement().executeQuery("SELECT * FROM computer");
            while(result.next()) {
                tmp = new Computer(result.getInt("id"), result.getString("name"), result.getDate("introduced").toLocalDate(), result.getDate("discontinued").toLocalDate(), result.getInt("company_id"));
                retAL.add(tmp);
            }

        }catch(SQLException e) {
            e.printStackTrace();
        }

        return retAL;
    }

    @Override
    public Computer find(int id) {
        // TODO Auto-generated method stub
        Computer comp = new Computer();
        try {
            ResultSet result = this.connect
                    .createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
                    .executeQuery("SELECT * FROM COMPUTER WHERE id = " + id);
            if (result.first())
                comp = new Computer(id, result.getString("name"), result.getDate("introduced").toLocalDate(),result.getDate("discontinued").toLocalDate(), result.getInt("company_id"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comp;
    }

}