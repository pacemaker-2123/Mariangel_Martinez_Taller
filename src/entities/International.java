package entities;

public class International extends Flight{
    private String countryD;
    private String visa;

    public International(String code, String originCity, String destinationCity, String date, String timeOut, String timeArrival, int size, int seatVacant, double price, int stateFlight, String countryD) {
        super(code, originCity, destinationCity, date, timeOut, timeArrival, size, seatVacant, price, stateFlight);
        this.countryD = countryD;
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
}
