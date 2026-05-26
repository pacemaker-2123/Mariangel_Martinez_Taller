package repositories;

import entities.Passenger;
import java.util.ArrayList;

public class PassengerRepository {
    private ArrayList<Passenger> listP = new ArrayList<>();

    public void save (Passenger p){
        listP.add(p);
    }

    public ArrayList<Passenger> listAll(){
        return listP;
    }

    public void printAllP(){
        listP.forEach(System.out::println);
    }

    public Passenger findById(long id){
        for(Passenger p:listP){
            if(p.getId() == id ){
                return p;
            }
        }
        return null;
    }

    public Passenger findByPassport(String passport){
        for(Passenger p:listP){
            if(p.getPassport().equals(passport)){
                return p;
            }
        }
        return null;
    }

    public int totalPassenger(){
        return listP.size();
    }

    public boolean delete(long id){
        return listP.removeIf(p -> p.getId() == id);
    }


}
