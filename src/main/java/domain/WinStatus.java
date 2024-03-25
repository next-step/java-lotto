package domain;

public class WinStatus {

    private final static int[] winCount = new int[4];

    public void correct(int count) {
        winCount[count]++;
    }
}
