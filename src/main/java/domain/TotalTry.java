package domain;

public class TotalTry {
    private int totalTry;
    private int manualTry;

    public TotalTry(int totalTry) {
        if (totalTry < 0)
            throw new IllegalArgumentException("0이상의 갯수를 필요로 합니다");
        this.totalTry = totalTry;
    }

    public void minus(int manualTry) {
        if (manualTry < 0)
            throw new IllegalArgumentException("0이상의 갯수를 필요로 합니다");
        this.manualTry = manualTry;
    }

    public int getTotalTry() {
        return totalTry - manualTry;
    }

    public int getManualTry() {
        return manualTry;
    }
}
