package domain;

public class TotalTry {
    private int totalTry;
    private int manualTry;

    public TotalTry(int totalTry) {
        errorControl(totalTry);
        this.totalTry = totalTry;
    }

    public void minus(int manualTry) {
        errorControl(manualTry);
        this.manualTry = manualTry;
    }

    private void errorControl(int tryCount) {
        if (tryCount < 0)
            throw new IllegalArgumentException("0이상의 갯수를 필요로 합니다");
    }

    public int getTotalTry() {
        return totalTry - manualTry;
    }

    public int getManualTry() {
        return manualTry;
    }
}
