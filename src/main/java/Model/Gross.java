package model;

public class Gross {
    private double gross;

    public Gross(int totalPrice, int totalMoney) {
        this.gross = Math.round((double) totalPrice / totalMoney * 100.0) / 100.0;
    }

    public double getGross() {
        return this.gross;
    }

}
