package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
//        Truck truck1 = new Truck("TATA","2015",1000,"Ramesh");
//        Truck truck2 = new Truck("EICHER","2020",1000,"Rakesh");
//        Truck truck3 = new Truck("MAHINDRA","2023",1000,"Mahesh");
//        System.out.println("Inserting data in Database");
//
//        ts.addTruck(truck1);
//        ts.addTruck(truck2);
//        ts.addTruck(truck3);
//        List<Truck> trucks = ts.getAllTrucks();
//        for(Truck t : trucks){
//            System.out.println(t);
//        }
//        truck1.setDriver_name("Anuj");
//        ts.updateTruck(truck1,1);
//        trucks = ts.getAllTrucks();
//        for(Truck t : trucks){
//            System.out.println(t);
//        }
        TruckService ts = new TruckService();
        Scanner sc = new Scanner(System.in);
        int choice = 1;
        while(choice==1){
            System.out.println("what do you want to perform : ");
            System.out.println("1. data insertion");
            System.out.println("2. data updation");
            System.out.println("3. Display all data");
            System.out.println("4. Get data by id");
            System.out.println("5. data deletion");
            int a = sc.nextInt();
            System.out.println("----------------------------------------------------------------");
            switch (a){
                case 1:
                    System.out.println("Enter data");
                    Truck t = new Truck();
                    System.out.println("Enter truck name : ");
                    t.setName(sc.next());
                    System.out.println("Enter truck model : ");
                    t.setModel(sc.next());
                    System.out.println("Enter truck capacity : ");
                    t.setCapacity(sc.nextInt());
                    System.out.println("Enter truck's Driver name : ");
                    t.setDriver_name(sc.next());
                    ts.addTruck(t);
                    break;
                case 2:
                    System.out.println("Enter the Truck id which you want to update : ");
                    int i = sc.nextInt();
                    Truck truck = ts.getTruckById(a);
                    System.out.println("Enter the updated name : ");
                    truck.setName(sc.next());
                    System.out.println("Enter the updated model : ");
                    truck.setModel(sc.next());
                    System.out.println("Enter the updated capacity : ");
                    truck.setCapacity(sc.nextInt());
                    System.out.println("Enter the updated driver name : ");
                    truck.setDriver_name(sc.next());
                    ts.updateTruck(truck,a);
                    break;
                case 3:
                    System.out.println("Displaying all data : ");
                    List<Truck> trucks = ts.getAllTrucks();
                    for(Truck tr : trucks){
                        System.out.println(tr);
                    }
                    break;
                case 4:
                    System.out.println("Enter the id of the truck which you want : ");
                    int z = sc.nextInt();
                    System.out.println(ts.getTruckById(z));
                    break;
                case 5:
                    System.out.println("Enter the id of the truck you want to delete : ");
                    int y = sc.nextInt();
                    ts.delete(y);
                    break;
                default:
                    System.out.println("Press 1 to continue or any other to terminate : ");
                    choice = sc.nextInt();
            }
        }
    }
}
