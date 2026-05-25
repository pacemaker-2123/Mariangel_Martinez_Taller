package entities;

public class Flight {
    private String code;
    private String originCity;
    private String destinationCity;
    private String date;
    private String timeOut;
    private String timeArrival;
    private int size;
    private int seatVacant;
    private double price;
    private int stateFlight;

    public Flight(String code, String originCity, String destinationCity, String date, String timeOut, String timeArrival, int size, int seatVacant , double price, int stateFlight) {
        this.code = code;
        this.originCity = originCity;
        this.destinationCity = destinationCity;
        this.date = date;
        this.timeOut = timeOut;
        this.timeArrival = timeArrival;
        this.size = size;
        this.seatVacant = seatVacant;
        this.price = price;
        this.stateFlight = stateFlight;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOriginCity() {
        return originCity;
    }

    public void setOriginCity(String originCity) {
        this.originCity = originCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(String timeOut) {
        this.timeOut = timeOut;
    }

    public String getTimeArrival() {
        return timeArrival;
    }

    public void setTimeArrival(String timeArrival) {
        this.timeArrival = timeArrival;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSeatVacant() {
        return seatVacant;
    }

    public void setSeatVacant(int seatVacant) {
        this.seatVacant = seatVacant;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStateFlight() {
        return stateFlight;
    }

    public void setStateFlight(int stateFlight) {
        this.stateFlight = stateFlight;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "code='" + code + '\'' +
                ", originCity='" + originCity + '\'' +
                ", destinationCity='" + destinationCity + '\'' +
                ", date='" + date + '\'' +
                ", timeOut='" + timeOut + '\'' +
                ", timeArrival='" + timeArrival + '\'' +
                ", size=" + size +
                ", seatVacant=" + seatVacant +
                ", price=" + price +
                ", stateFlight=" + stateFlight +
                '}';
    }
}
