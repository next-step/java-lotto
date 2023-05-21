package domain;

public class GameCount {
    private int manualCount;
    private int automaticCount;

    public GameCount(int totalCount, int manualCount) {
        this.manualCount = manualCount;
        this.automaticCount = totalCount - manualCount;
    }
}
