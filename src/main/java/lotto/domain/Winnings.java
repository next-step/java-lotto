package lotto.domain;

public enum Winnings {

    사등("3개", 5000),
    삼등("4개", 50000),
    이등("5개", 1500000),
    일등("6개", 2000000000);

    public static final int WRONG_VALUE = 0;

    private String numberOfSame;
    private int winnings;

    Winnings(String numberOfSame, int winnings) {
        this.numberOfSame = numberOfSame;
        this.winnings = winnings;
    }

    public static int selectWinnings(String numberOfSame) {
        if (사등.numberOfSame.equals(numberOfSame)) {
            return 사등.winnings;
        }
        if (삼등.numberOfSame.equals(numberOfSame)) {
            return 삼등.winnings;
        }
        if (이등.numberOfSame.equals(numberOfSame)) {
            return 이등.winnings;
        }
        if (일등.numberOfSame.equals(numberOfSame)) {
            return 일등.winnings;
        }
        return WRONG_VALUE;
    }
}
