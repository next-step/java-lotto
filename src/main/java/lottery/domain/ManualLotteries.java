package lottery.domain;

public class ManualLotteries {

    public static final int MINIMUM_COUNT = 0;

    public static void validateGenerateCount(int countOfTotalLotteries, int countOfManualLotteries) {
        validateMinimumCount(countOfManualLotteries);
        validateMaximumCount(countOfTotalLotteries, countOfManualLotteries);
    }

    private static void validateMaximumCount(int countOfTotalLotteries, int countOfManualLotteries) {
        if (countOfTotalLotteries < countOfManualLotteries) {
            throw new IllegalArgumentException("수동 로또 개수가 모든 로또의 생성 개수보다 클 수 없습니다.");
        }
    }

    private static void validateMinimumCount(int countOfManualLotteries) {
        if (countOfManualLotteries < MINIMUM_COUNT) {
            throw new IllegalArgumentException("잘못된 수동 로또 개수를 입력하였습니다 : " + countOfManualLotteries);
        }
    }
}
