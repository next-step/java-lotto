package domain;

public class WinStatus {

    private static int[] winCount;

    public void correct(int count) {
        winCount[count]++;
    }

    public WinStatus() {
        winCount = new int[4];
    }

    public int[] getWinCount() {
        return winCount;
    }
}
