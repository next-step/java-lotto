package lottery.domain;

public class GenerateCount {

    public static final int MINIMUM = 0;

    private final int count;

    public GenerateCount(int count) {
        this.count = count;
    }

    public static GenerateCount ofAutoLottery(int count) {
        validateAutoLottery(count);

        return new GenerateCount(count);
    }

    private static void validateAutoLottery(int count) {
        if (count < MINIMUM) {
            throw new IllegalArgumentException("로또 생성 개수는 " + MINIMUM + "개 이상이어야 합니다.");
        }
    }

    public static GenerateCount ofManualLottery(int countOfTotalLotteries, int countOfManualLotteries) {
        validateManualLottery(countOfTotalLotteries, countOfManualLotteries);

        return new GenerateCount(countOfManualLotteries);
    }

    private static void validateManualLottery(int countOfTotalLotteries, int countOfManualLotteries) {
        validateMinimumCount(countOfManualLotteries);
        validateMaximumCount(countOfTotalLotteries, countOfManualLotteries);
    }

    private static void validateMinimumCount(int countOfManualLotteries) {
        if (countOfManualLotteries < MINIMUM) {
            throw new IllegalArgumentException("잘못된 수동 로또 개수를 입력하였습니다 : " + countOfManualLotteries);
        }
    }

    private static void validateMaximumCount(int countOfTotalLotteries, int countOfManualLotteries) {
        if (countOfTotalLotteries < countOfManualLotteries) {
            throw new IllegalArgumentException("수동 로또 개수가 모든 로또의 생성 개수보다 클 수 없습니다.");
        }
    }

    public int count() {
        return count;
    }

    @Override
    public String toString() {
        return String.valueOf(count);
    }
}
