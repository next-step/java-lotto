package Model;

public class Gross {
    double gross;

    public Gross(int getMoney, int totalMoney) {

        this.gross = Math.round((double) getMoney / totalMoney * 100.0) / 100.0;
    }

    public double getGross() {
        return this.gross;
    }
}
