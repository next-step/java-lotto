package step2.service;

public enum LottoRank {

    MATCH_THREE(3, 5000),
    MATCH_FOUR(4, 50000),
    MATCH_FIVE(5, 1500000),
    MATCH_SIX(6, 2000000000);

    private final int countOfMatch;

    private final long prizeAmount;

    LottoRank(int countOfMatch, long prizeAmount) {
        this.countOfMatch = countOfMatch;
        this.prizeAmount = prizeAmount;
    }

    public static boolean isMatchingThree(Integer matchingCount) {
        return matchingCount == MATCH_THREE.countOfMatch;
    }

    public static boolean isMatchingFour(Integer matchingCount) {
        return matchingCount == MATCH_FOUR.countOfMatch;
    }

    public static boolean isMatchingFive(Integer matchingCount) {
        return matchingCount == MATCH_FIVE.countOfMatch;
    }

    public static boolean isMatchingSix(Integer matchingCount) {
        return matchingCount == MATCH_SIX.countOfMatch;
    }

    public static long getMatchThreePrizeAmount(Integer numOfWinner) {
        return numOfWinner * MATCH_THREE.prizeAmount;
    }

    public static long getMatchFourPrizeAmount(Integer numOfWinner) {
        return numOfWinner * MATCH_FOUR.prizeAmount;
    }

    public static long getMatchFivePrizeAmount(Integer numOfWinner) {
        return numOfWinner * MATCH_FIVE.prizeAmount;
    }

    public static long getMatchSixPrizeAmount(Integer numOfWinner) {
        return numOfWinner * MATCH_SIX.prizeAmount;
    }
}
