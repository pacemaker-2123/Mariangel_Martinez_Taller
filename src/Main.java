import entities.Passenger;
import entities.Flight;
import entities.National;
import entities.International;
import entities.Reservations;
import service.FlightService;
import service.PassengerService;
import service.ReservationsService;

import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        PassengerService pS = new PassengerService();
        FlightService fS = new FlightService();
        ReservationsService rS = new ReservationsService(pS, fS);
        Scanner scanner = new Scanner(System.in);

        int option;

        do{
            System.out.println("\n+====== FLUXIOAIR ======+");
            System.out.println("|1.- GESTION DE PASAJEROS |");
            System.out.println("|2.- GESTION DE VUELOS    |");
            System.out.println("|3.- RESERVACIONES        |");
            System.out.println("|4.- REPORTES             |");
            System.out.println("|0.- SALIR                |");
            System.out.println("+=========================+");
            System.out.println("SELECCIONE UNA OPCION: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option){
                case 1: passengerMenu(scanner, pS);break;
                case 2: flightMenu(scanner,fS);break;
                case 3: reservationMenu(scanner,rS);break;
                case 4: reportMenu(scanner, rS,pS);break;
                case 0: System.out.println("CERRANDO...");break;
                default: System.out.println("OPCION NO VALIDA...");
            }

        }while(option !=0);
        scanner.close();
    }

    static void passengerMenu(Scanner scanner, PassengerService pS){
        int option;
        do{
            System.out.println("\n+==== GESTION DE PASAJEROS ====+");
            System.out.println("|1.- REGISTRAR PASAJERO          |");
            System.out.println("|2.- TOTAL DE PASAJEROS          |");
            System.out.println("|0.- SALIR                       |");
            System.out.println("+================================+");
            System.out.println("SELECCIONE UNA OPCION: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option){
                case 1: registerPassenger(scanner,pS);break;
                case 2:System.out.println("TOTAL DE PASAJEROS: " + pS.totalP());;break;
                case 0: System.out.println("VOLVIENDO...");break;
                default: System.out.println("OPCION NO VALIDA...");
            }
        }while (option!=0);
    }

    static void registerPassenger(Scanner scanner, PassengerService pS){
        try {
            System.out.println("\n====== REGISTRO DE PASAJERO ======");
            System.out.print("CEDULA: "); long id = scanner.nextLong(); scanner.nextLine();
            System.out.print("NOMBRE: "); String name = scanner.nextLine();
            System.out.print("APELLIDO: "); String lastName = scanner.nextLine();
            System.out.print("EDAD: "); int age = scanner.nextInt(); scanner.nextLine();
            System.out.print("EMAIL: "); String email = scanner.nextLine();
            System.out.print("TELEFONO: "); String phone = scanner.nextLine();
            System.out.print("PASAPORTE: "); String passport = scanner.nextLine();
            System.out.print("NACIONALIDAD: "); String nationality = scanner.nextLine();

            Passenger p = new Passenger(id, name, lastName, age, email, phone, passport, nationality);
            pS.savePassenger(p);
            System.out.println("PASAJERO REGISTRADO EXITOSAMENTE!");
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
    static void flightMenu(Scanner scanner, FlightService fS) {
        int option;
        do {
            System.out.println("\n+====== GESTION DE VUELOS ======+");
            System.out.println("|1.- REGISTRAR VUELO NACIONAL   |");
            System.out.println("|2.- REGISTRAR VUELO INTERN.    |");
            System.out.println("|0.- VOLVER                     |");
            System.out.println("+===============================+");
            System.out.print("SELECCIONE UNA OPCION: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1: registerNational(scanner, fS); break;
                case 2: registerInternational(scanner, fS); break;
                case 0: System.out.println("VOLVIENDO..."); break;
                default: System.out.println("OPCION NO VALIDA...");
            }
        } while (option != 0);
    }

    static void registerNational(Scanner scanner, FlightService fS) {
        try {
            System.out.println("\n====== REGISTRO VUELO NACIONAL ======");
            System.out.print("CODIGO: "); String code = scanner.nextLine();
            System.out.print("CIUDAD ORIGEN: "); String origin = scanner.nextLine();
            System.out.print("CIUDAD DESTINO: "); String destination = scanner.nextLine();
            System.out.print("FECHA (DD/MM/YYYY): "); String date = scanner.nextLine();
            System.out.print("HORA SALIDA (HH:MM): "); String timeOut = scanner.nextLine();
            System.out.print("HORA LLEGADA (HH:MM): "); String timeArrival = scanner.nextLine();
            System.out.print("CAPACIDAD TOTAL: "); int size = scanner.nextInt(); scanner.nextLine();
            System.out.print("PRECIO BASE: "); double price = scanner.nextDouble(); scanner.nextLine();
            System.out.print("DURACION (horas): "); float duration = scanner.nextFloat(); scanner.nextLine();
            System.out.print("INCLUYE ALIMENTACION (SI/NO): "); String alimentation = scanner.nextLine();

            National n = new National(code, origin, destination, date, timeOut, timeArrival, size, size, price, 1, duration, alimentation);
            fS.saveFlight(n);
            System.out.println("VUELO NACIONAL REGISTRADO EXITOSAMENTE!");
            System.out.println("PRECIO FINAL: $" + fS.calculateFinalPrice(n));
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    static void registerInternational(Scanner scanner, FlightService fS) {
        try {
            System.out.println("\n====== REGISTRO VUELO INTERNACIONAL ======");
            System.out.print("CODIGO: "); String code = scanner.nextLine();
            System.out.print("CIUDAD ORIGEN: "); String origin = scanner.nextLine();
            System.out.print("CIUDAD DESTINO: "); String destination = scanner.nextLine();
            System.out.print("FECHA (DD/MM/YYYY): "); String date = scanner.nextLine();
            System.out.print("HORA SALIDA (HH:MM): "); String timeOut = scanner.nextLine();
            System.out.print("HORA LLEGADA (HH:MM): "); String timeArrival = scanner.nextLine();
            System.out.print("CAPACIDAD TOTAL: "); int size = scanner.nextInt(); scanner.nextLine();
            System.out.print("PRECIO BASE: "); double price = scanner.nextDouble(); scanner.nextLine();
            System.out.print("PAIS DESTINO: "); String country = scanner.nextLine();
            System.out.print("REQUIERE VISA (SI/NO): "); String visa = scanner.nextLine();
            System.out.print("CARGO INTERNACIONAL: "); double charge = scanner.nextDouble(); scanner.nextLine();

            International i = new International(code, origin, destination, date, timeOut, timeArrival, size, size, price, 1, country, visa, charge);
            fS.saveFlight(i);
            System.out.println("VUELO INTERNACIONAL REGISTRADO EXITOSAMENTE!");
            System.out.println("PRECIO FINAL: $" + fS.calculateFinalPrice(i));
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    static void reservationMenu(Scanner scanner, ReservationsService rS) {
        int option;
        do {
            System.out.println("\n+====== RESERVACIONES ======+");
            System.out.println("|1.- CREAR RESERVA          |");
            System.out.println("|2.- CANCELAR RESERVA       |");
            System.out.println("|0.- VOLVER                 |");
            System.out.println("+===========================+");
            System.out.print("SELECCIONE UNA OPCION: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1: createReservation(scanner, rS); break;
                case 2: cancelReservation(scanner, rS); break;
                case 0: System.out.println("VOLVIENDO..."); break;
                default: System.out.println("OPCION NO VALIDA...");
            }
        } while (option != 0);
    }

    static void createReservation(Scanner scanner, ReservationsService rS) {
        try {
            System.out.println("\n======CREAR RESERVA ======");
            System.out.print("CODIGO DE RESERVA: "); String code = scanner.nextLine();
            System.out.print("CEDULA DEL PASAJERO: "); long id = scanner.nextLong(); scanner.nextLine();
            System.out.print("CODIGO DEL VUELO: "); String codeFlight = scanner.nextLine();
            System.out.print("CANTIDAD DE ASIENTOS (1-5): "); int seats = scanner.nextInt(); scanner.nextLine();
            System.out.print("FECHA DE RESERVA (DD/MM/YYYY): "); String date = scanner.nextLine();

            Reservations r = new Reservations(code, id, codeFlight, seats, date, 0, 0);
            rS.SaveReservation(r);
            System.out.println("RESERVA CREADA EXITOSAMENTE!");
            System.out.println("PRECIO TOTAL: $" + r.getPriceR());
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    static void cancelReservation(Scanner scanner, ReservationsService rS) {
        try {
            System.out.println("\n====== CANCELAR RESERVA ======");
            System.out.print("CODIGO DE RESERVA: "); String code = scanner.nextLine();
            rS.cancelReservation(code);
            System.out.println("RESERVA CANCELADA EXITOSAMENTE!");
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    static void reportMenu(Scanner scanner, ReservationsService rS, PassengerService pS) {
        int option;
        do {
            System.out.println("\n+====== REPORTES ======+");
            System.out.println("|1.- RESERVA POR CODIGO|");
            System.out.println("|2.- TOTAL PASAJEROS   |");
            System.out.println("|3.- RESERVAS PASAJERO |");
            System.out.println("|0.- VOLVER            |");
            System.out.println("+=====================+");
            System.out.print("SELECCIONE UNA OPCION: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1: findReservationByCode(scanner, rS); break;
                case 2: System.out.println("TOTAL DE PASAJEROS: " + pS.totalP()); break;
                case 3: findReservationByPassenger(scanner, rS); break;
                case 0: System.out.println("VOLVIENDO..."); break;
                default: System.out.println("OPCION NO VALIDA...");
            }
        } while (option != 0);
    }

    static void findReservationByCode(Scanner scanner, ReservationsService rS) {
        try {
            System.out.print("INGRESE CODIGO DE RESERVA: "); String code = scanner.nextLine();
            Reservations r = rS.findByCodeR(code);
            System.out.println("\n====== INFORMACION DE RESERVA ======");
            printReservation(r);
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    static void findReservationByPassenger(Scanner scanner, ReservationsService rS) {
        try {
            System.out.print("INGRESE CEDULA DEL PASAJERO: "); long id = scanner.nextLong(); scanner.nextLine();
            ArrayList<Reservations> list = rS.findByPassenger(id);
            if (list.isEmpty()) {
                System.out.println("EL PASAJERO NO TIENE RESERVAS");
            } else {
                System.out.println("\n====== RESERVAS DEL PASAJERO ======");
                for(Reservations r : list){
                    printReservation(r);
                    System.out.println("----------");
                }
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
    static void printReservation(Reservations r) {
        System.out.println("CODIGO RESERVA: " + r.getCodeReservation());
        System.out.println("CEDULA PASAJERO: " + r.getIdR());
        System.out.println("CODIGO VUELO: " + r.getCodeFlight());
        System.out.println("ASIENTOS: " + r.getSeats());
        System.out.println("FECHA: " + r.getDateR());
        System.out.println("PRECIO TOTAL: $" + r.getPriceR());
        String state;
        switch (r.getStateR()) {
            case 1: state = "Confirmada"; break;
            case 2: state = "Cancelada"; break;
            case 3: state = "Completada"; break;
            default: state = "Desconocido";
        }
        System.out.println("ESTADO: " + state);
    }
}
