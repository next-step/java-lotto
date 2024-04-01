package domain;

public class WinStatus {

    private static int[] winCount;

    public void correct(int count) {
        if (count >= 3)
            winCount[count - 3]++;
    }

    public WinStatus() {
        winCount = new int[4];
    }

    public int[] getWinCount() {
        return winCount;
    }
}
