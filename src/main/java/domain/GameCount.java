package domain;

public class GameCount {
    private final int manualCount;
    private final int automaticCount;

    public GameCount(int totalCount, int manualCount) {
        this.manualCount = manualCount;
        this.automaticCount = totalCount - manualCount;
    }

    public int getAutomaticCount() {
        return automaticCount;
    }
}
