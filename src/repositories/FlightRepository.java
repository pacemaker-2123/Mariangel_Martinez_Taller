package repositories;

import entities.Flight;

import java.util.ArrayList;

public class FlightRepository {
    private ArrayList<Flight> listF = new ArrayList<>();

    public void saveF (Flight f){
        listF.add(f);
    }

    public ArrayList<Flight> listAllF(){
        return listF;
    }

    public Flight findBycode(String code){
        for (Flight f : listF){
            if (f.getCode().equals(code)) {
                return f;
            }
        }
        return null;
    }
}
