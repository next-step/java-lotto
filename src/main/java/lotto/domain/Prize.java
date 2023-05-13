package lotto.domain;

public class Prize {
    public static final int FIRST_PRIZE = 2000000000;
    public static final int SECOND_PRIZE = 1500000;
    public static final int THIRD_PRIZE = 50000;
    public static final int FOURTH_PRIZE = 5000;
    private final int[] matchingResult;

    private Prize(int[] matchingResult) {
        this.matchingResult = matchingResult;
    }

    public static Prize from(int[] matchingResult) {
        return new Prize(matchingResult);
    }

    public long sumOfPrize() {
        long sumOfFirstPrize = FIRST_PRIZE * countOfMatchingNumber(6);
        long sumOfSecondPrize = SECOND_PRIZE * countOfMatchingNumber(5);
        long sumOfThirdPrize = THIRD_PRIZE * countOfMatchingNumber(4);
        long sumOfFourthPrize = FOURTH_PRIZE * countOfMatchingNumber(3);
        return sumOfFirstPrize + sumOfSecondPrize + sumOfThirdPrize + sumOfFourthPrize;
    }

    private int countOfMatchingNumber(int number) {
        return this.matchingResult[number];
    }
}
