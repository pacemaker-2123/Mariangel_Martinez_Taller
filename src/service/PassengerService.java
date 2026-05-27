package service;
import repositories.PassengerRepository;
import entities.Passenger;

public class PassengerService {
    private PassengerRepository pR = new PassengerRepository();

    public void SavePassenger(Passenger passenger) throws Exception{
        //Validation of Data;
        if ((passenger.getAge() < 0) || (passenger.getAge() >= 120)){
            throw new Exception("LA EDAD DEBE SER MAYOR O IGUAL A 0");
        }
        if ((pR.findById(passenger.getId()) != null)){
            throw new Exception("YA EXISTE UN PASAJERO CON ESTA CEDULA");
        }
        if ((pR.findByPassport(passenger.getPassport()) != null)){
            throw new Exception("YA EXISTE UN PASAJERO CON ESTE PASAPORTE");
        }
        if (!passenger.getEmail().contains("@")){
            throw new Exception("EL EMAIL DEBE CONTENER EL SIMBOLO | @ |");
        }
        pR.save(passenger);
    }

    public int totalP(){
        return pR.totalPassenger();
    }

    public Passenger findById(long id) throws Exception{
        Passenger p = pR.findById(id);
        if (p == null){
            throw new Exception("NO SE ENCONTRO AL PASAJERO");
        }
        return p;
    }

}
