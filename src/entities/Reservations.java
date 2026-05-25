package entities;

public class Reservations {
    private String codeReservation;
    private long idR;
    private String codeR;
    private int seats;
    private String dateR;
    private double priceR;
    private int stateR;

    public Reservations(String codeReservation, long idR, String codeR, int seats, String dateR, double priceR, int stateR) {
        this.codeReservation = codeReservation;
        this.idR = idR;
        this.codeR = codeR;
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

    public String getCodeR() {
        return codeR;
    }

    public void setCodeR(String codeR) {
        this.codeR = codeR;
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
                ", codeR='" + codeR + '\'' +
                ", seats=" + seats +
                ", dateR='" + dateR + '\'' +
                ", priceR=" + priceR +
                ", stateR=" + stateR +
                '}';
    }
}
