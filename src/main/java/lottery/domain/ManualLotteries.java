package lottery.domain;

public class ManualLotteries {

    public static void validateGenerateCount(int countOfTotalLotteries, int countOfManualLotteries) {
        if (countOfManualLotteries < 0) {
            throw new IllegalArgumentException("잘못된 수동 로또개수를 입력하였습니다 : " + countOfManualLotteries);
        }

        if (countOfTotalLotteries < countOfManualLotteries) {
            throw new IllegalArgumentException("수동 로또 개수가 모든 로또의 생성 개수보다 클 수 없습니다.");
        }
    }
}
