package entities;

public class National extends Flight {
    private float duration;
    private String alimentation;

    public National(String code, String originCity, String destinationCity, String date, String timeOut, String timeArrival, int size, int seatVacant, double price, int stateFlight, float duration, String alimentation) {
        super(code, originCity, destinationCity, date, timeOut, timeArrival, size, seatVacant, price, stateFlight);
        this.duration = duration;
        this.alimentation = alimentation;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public String getAlimentation() {
        return alimentation;
    }

    public void setAlimentation(String alimentation) {
        this.alimentation = alimentation;
    }

    @Override
    public String toString() {
        return "National{" +
                "duration=" + duration +
                ", alimentation='" + alimentation + '\'' +
                '}';
    }
}
