package lotto.domain;

public enum WinningsType {

    사등(3, 5000),
    삼등(4, 50_000),
    이등(5, 1500_000),
    일등(6, 2_000_000_000);

    public static final int WRONG_VALUE = 0;

    private int numberOfSame;
    private int winnings;

    WinningsType(int numberOfSame, int winnings) {
        this.numberOfSame = numberOfSame;
        this.winnings = winnings;
    }

    public static WinningsType selectWinningsType(int numberOfSame) {
        if (사등.numberOfSame == numberOfSame) {
            return WinningsType.사등;
        }
        if (삼등.numberOfSame == numberOfSame) {
            return WinningsType.삼등;
        }
        if (이등.numberOfSame == numberOfSame) {
            return WinningsType.이등;
        }
        if (일등.numberOfSame == numberOfSame) {
            return WinningsType.일등;
        }
        return null;
    }

    public static int selectNumberOfSame(String winningsType) {
        if ("사등".equals(winningsType)) {
            return 사등.numberOfSame;
        }
        if ("삼등".equals(winningsType)) {
            return 삼등.numberOfSame;
        }
        if ("이등".equals(winningsType)) {
            return 이등.numberOfSame;
        }
        if ("일등".equals(winningsType)) {
            return 일등.numberOfSame;
        }
        return WRONG_VALUE;
    }

    public static int selectWinnings(int numberOfSame) {
        if (사등.numberOfSame == numberOfSame) {
            return 사등.winnings;
        }
        if (삼등.numberOfSame == numberOfSame) {
            return 삼등.winnings;
        }
        if (이등.numberOfSame == numberOfSame) {
            return 이등.winnings;
        }
        if (일등.numberOfSame == numberOfSame) {
            return 일등.winnings;
        }
        return WRONG_VALUE;
    }
}
