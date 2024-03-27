package autoLotto.model;

public class LottoPurchaseCount {
    private static final String INVALID_NUMBER_OF_PURCHASE_COUNT = "전체 구매 로또의 수보다 수동 로또의 개수, 또는 자동 로또의 개수가 많을 수 없습니다.";
    private static final int KOREAN_DOLLAR_UNIT = 1000;

    private final int numberOfTotalLottos;
    private final int numberOfManualLottos;
    private final int numberOfAutoLottos;

    public LottoPurchaseCount(int purchaseAmount, int numberOfManualLottos) {
        this.numberOfTotalLottos = purchaseAmount / KOREAN_DOLLAR_UNIT;
        this.numberOfManualLottos = numberOfManualLottos;
        this.numberOfAutoLottos = calculateNumberOfAutoLottos(numberOfTotalLottos, numberOfManualLottos);
    }

    private int calculateNumberOfAutoLottos(int numberOfTotalLottos, int numberOfManualLottos) {
        if (numberOfTotalLottos < numberOfManualLottos) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PURCHASE_COUNT);
        }

        return numberOfTotalLottos - numberOfManualLottos;
    }

    public int getNumberOfAutoLottos() {
        return numberOfAutoLottos;
    }

    public int getNumberOfTotalLottos() {
        return numberOfTotalLottos;
    }

    public int getNumberOfManualLottos() {
        return numberOfManualLottos;
    }
}
