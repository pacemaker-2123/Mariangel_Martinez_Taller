package service;
import entities.Flight;
import entities.National;
import entities.International;
import repositories.FlightRepository;

public class FlightService {
    private FlightRepository fR = new FlightRepository();

    public void saveFlight(Flight fligth) throws Exception{
       //validation
        if ((fR.findBycode(fligth.getCode()) != null)){
            throw new Exception("YA EXISTE UN PASAJERO CON ESTE CODIGO");
        }
        if (fligth.getSize() <= 0){
            throw new Exception("LA CAPACIDAD TOTAL DEBE SER MAYOR 0");
        }
        if (fligth.getSeatVacant() != fligth.getSize()) {
            throw new Exception("LOS ASIENTOS DISPONIBLES DEBEN SER IGUALES A LA CAPACIDAD TOTAL");
        }
        if(fligth.getPrice() <= 0){
            throw new Exception("EL PRECIO BASE DEBE SER MAYOR A 0");
        }
        fR.saveF(fligth);
    }

    public Flight finByCode(String code) throws Exception{
        Flight f = fR.findBycode(code);
        if (f == null) {
           throw new Exception("NO SE ENCONTRO EL REGISTRO DEL VUELO");
        }
        if ((f.getStateFlight() != 1)){
            throw new Exception("EL VUELO NO ESTA EN ESTADO PROGRAMADO");
        }
        return f;
    }

    public double calculateFinalPrice(Flight flights) {
        if (flights instanceof International) {
            International i = (International) flights;
            return i.getPrice() + i.getCharge();
        }
        return flights.getPrice();
    }
}
