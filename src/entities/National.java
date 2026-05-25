package entities;

public class National extends Flight {
    private float duration;
    private boolean alimentation;

    public National(String code, String originCity, String destinationCity, String date, String timeOut, String timeArrival, int size, int seatVacant, double price, int stateFlight, float duration, boolean alimentation) {
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

    public boolean getAlimentation() {
        return alimentation;
    }

    public void setAlimentation(boolean alimentation) {
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
