package lotto;

public class Revenue {
    double revenue;

    public Revenue(int revenue) {
        this.revenue = revenue;
    }

    public double divide(int denominator) {
        return revenue / (double) denominator;
    }
}
