package repositories;

import entities.Reservations;

import java.util.ArrayList;

public class ReservationRepository {
    private ArrayList<Reservations> listR = new ArrayList<>();

    public void saveR(Reservations r){
      listR.add(r);
    }

    public Reservations findBycodeR(String codeReservation){
       for (Reservations r : listR){
           if(r.getCodeReservation().equals(codeReservation)){
               return r;
           }
       }
       return null;
    }

    public ArrayList<Reservations> findByPassenger(long id){
        ArrayList<Reservations> result = new ArrayList<>();
        for (Reservations r : listR){
            if(r.getIdR() == id){
                result.add(r);
            }
        }
        return result;
    }

}
