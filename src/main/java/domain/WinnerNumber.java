package domain;

public class WinnerNumber {
    public static final int RECORD_SIZE = 7;
    private int[] winnerNumber;
    private int[] rankRecord;

    public WinnerNumber(int[] number) {
        rankRecord = new int[RECORD_SIZE];
        this.winnerNumber = number;
    }

    public int[] getRankRecord() {
        return rankRecord;
    }

    public int[] getWinnerNumber() {
        return winnerNumber;
    }

    public int calculateWinnerRank(int count) {
        int price = 0;

        for (WinnerRanking rank : WinnerRanking.values()) {
            if (rank.getCount() == count) {
                rankRecord[count]++;
                price = rank.getWinnerPrice();
                break;
            }
        }
        return price;
    }
}
