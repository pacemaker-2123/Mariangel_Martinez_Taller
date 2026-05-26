package entities;

public class Reservations {
    private String codeReservation;
    private long idR;
    private String codeFlight;
    private int seats;
    private String dateR;
    private double priceR;
    private int stateR;

    public Reservations(String codeReservation, long idR, String codeFlight, int seats, String dateR, double priceR, int stateR) {
        this.codeReservation = codeReservation;
        this.idR = idR;
        this.codeFlight = codeFlight;
        this.seats = seats;
        this.dateR = dateR;
        this.priceR = priceR;
        this.stateR = stateR;
    }

    public String getCodeReservation() {
        return codeReservation;
    }

    public void setCodeReservation(String codeReservation) {
        this.codeReservation = codeReservation;
    }

    public long getIdR() {
        return idR;
    }

    public void setIdR(long idR) {
        this.idR = idR;
    }

    public String getCodeFlight() {
        return codeFlight;
    }

    public void setCodeFlight(String codeFlight) {
        this.codeFlight = codeFlight;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getDateR() {
        return dateR;
    }

    public void setDateR(String dateR) {
        this.dateR = dateR;
    }

    public double getPriceR() {
        return priceR;
    }

    public void setPriceR(double priceR) {
        this.priceR = priceR;
    }

    public int getStateR() {
        return stateR;
    }

    public void setStateR(int stateR) {
        this.stateR = stateR;
    }

    @Override
    public String toString() {
        return "Reservations{" +
                "codeReservation='" + codeReservation + '\'' +
                ", idR=" + idR +
                ", codeR='" + codeFlight + '\'' +
                ", seats=" + seats +
                ", dateR='" + dateR + '\'' +
                ", priceR=" + priceR +
                ", stateR=" + stateR +
                '}';
    }
}
