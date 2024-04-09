package domain;

public class TotalTry {
    private int totalTry;
    private int manualTry;

    public TotalTry(int totalTry) {
        this.totalTry = totalTry;
    }

    public void minus(int manualTry) {
        this.manualTry = manualTry;
    }

    public int getTotalTry() {
        return totalTry - manualTry;
    }

    public int getManualTry() {
        return manualTry;
    }
}
