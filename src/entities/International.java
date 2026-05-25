package entities;

public class International extends Flight {
    private String countryD;
    private String visa;
    private double charge;

    public International(String code, String originCity, String destinationCity, String date, String timeOut, String timeArrival, int size, int seatVacant, double price, int stateFlight, String countryD, String visa, double charge) {
        super(code, originCity, destinationCity, date, timeOut, timeArrival, size, seatVacant, price, stateFlight);
        this.countryD = countryD;
        this.visa = visa;
        this.charge = charge;
    }

    public String getCountryD() {
        return countryD;
    }

    public void setCountryD(String countryD) {
        this.countryD = countryD;
    }

    public String getVisa() {
        return visa;
    }

    public void setVisa(String visa) {
        this.visa = visa;
    }

    public double getCharge() {
        return charge;
    }

    public void setCharge(double charge) {
        this.charge = charge;
    }

    @Override
    public String toString() {
        return "International{" +
                "countryD='" + countryD + '\'' +
                ", visa='" + visa + '\'' +
                ", charge=" + charge +
                '}';
    }
}
