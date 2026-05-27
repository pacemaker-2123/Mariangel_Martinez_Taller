package service;
import entities.Flight;
import entities.Reservations;
import repositories.ReservationsRepository;

import java.util.ArrayList;

public class ReservationsService {
    private ReservationsRepository rR = new ReservationsRepository();
    private PassengerService pS = new PassengerService();
    private FlightService fS = new FlightService();


    public void SaveReservation(Reservations reservations) throws Exception {
        if (rR.findBycodeR(reservations.getCodeReservation()) != null){
            throw new Exception("YA EXISTE UNA RESERVA CON ESTE CODIGO");
        }
        if (reservations.getSeats() < 1 || reservations.getSeats() > 5){
            throw new Exception("LA CANTIDAD DE ASIENTOS DEBE SER MINIMO 1 Y MAXIMO 5");
        }
        pS.findById(reservations.getIdR());
        Flight f = fS.findByCode(reservations.getCodeFlight());
        if (f.getSeatVacant() < reservations.getSeats()){
            throw new Exception("NO HAY ASIENTOS DISPONIBLES PARA ESTE VUELO");
        }
        double totalPrice = fS.calculateFinalPrice(f) * reservations.getSeats();
        reservations.setPriceR(totalPrice);
        reservations.setStateR(1);
        f.setSeatVacant(f.getSeatVacant() - reservations.getSeats());
        rR.saveR(reservations);
    }


    public void cancelReservation(String codeReservation) throws Exception{
        Reservations r = rR.findBycodeR(codeReservation);
        if (r==null){
            throw new Exception("NO SE ENCONTRO LA RESERVA CON ESE CODIGO");
        }
        if(r.getStateR() != 1){
            throw new Exception("LA RESERVA NO ESTA CONFIRMADA");
        }

        r.setStateR(2);

        Flight f = fS.getByCode((r.getCodeFlight()));
        f.setSeatVacant(f.getSeatVacant() + r.getSeats());
    }

    public Reservations findByCodeR(String code) throws Exception {
        Reservations r = rR.findBycodeR(code);
        if (r == null){
            throw new Exception("NO SE ENCONTRO LA RESERVA CON ESE CODIGO");
        }
        return r;
    }

    public ArrayList<Reservations> findByPassenger(long id) throws Exception {
        pS.findById(id); // verifica que el pasajero existe
        return rR.findByPassenger(id);
    }
}
