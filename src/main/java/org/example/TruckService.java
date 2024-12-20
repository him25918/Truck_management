package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TruckService {
    public void addTruck(Truck truck){
        String sql = "insert into truck (name,model,capacity,driver_name) values (?,?,?,?)";
        try{
        Connection connection = ConnectionDetails.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, truck.getName());
        ps.setString(2, truck.getModel());
        ps.setInt(3, truck.getCapacity());
        ps.setString(4, truck.getDriver_name());
        int update = ps.executeUpdate();
        System.out.println("Row inserted : "+update);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Truck getTruckById(int id){
        String sql = "select * from truck where id = ?";
        Truck truck = new Truck();
        try{
            Connection connection = ConnectionDetails.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()){
                truck.setId(resultSet.getInt("id"));
                truck.setName(resultSet.getString("name"));
                truck.setModel(resultSet.getString("model"));
                truck.setId(resultSet.getInt("capacity"));
                truck.setDriver_name(resultSet.getString("driver_name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return truck;
    }
    public void updateTruck(Truck truck,int id){
        String sql = "update truck set name = ?, model = ?, capacity = ?, driver_name = ? where id = ?";
        try{
            Connection connection = ConnectionDetails.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, truck.getName());
            ps.setString(2, truck.getModel());
            ps.setInt(3, truck.getCapacity());
            ps.setString(4, truck.getDriver_name());
            ps.setInt(5, id);
            int update = ps.executeUpdate();
            System.out.println("Row updated : "+update);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public List<Truck> getAllTrucks(){
        String sql = "select * from truck";
        List<Truck> trucks = new ArrayList<>();
        try{
            Connection connection = ConnectionDetails.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                Truck truck = new Truck();
                truck.setId(resultSet.getInt("id"));
                truck.setName(resultSet.getString("name"));
                truck.setModel(resultSet.getString("model"));
                truck.setCapacity(resultSet.getInt("capacity"));
                truck.setDriver_name(resultSet.getString("driver_name"));
                trucks.add(truck);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return trucks;
    }

    public void delete(int id){
        String sql = "delete from truck where id = ?";
        try{
            Connection connection = ConnectionDetails.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            int i = ps.executeUpdate();
            System.out.println("Row deleted : " + i);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
