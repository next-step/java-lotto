package lotto.domain;

public class Profit {
    private double totalPrize;
    private int totalGameCost;

    public Profit(double totalPrize, int totalGames) {
        this.totalPrize = totalPrize;
        this.totalGameCost = totalGames;
    }

    public double calculateRate() {
        if( totalGameCost == 0) {
            return 0.00;
        }
        return Math.floor(this.totalPrize / totalGameCost * 100) / 100;
    }

}
