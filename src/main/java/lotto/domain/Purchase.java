package lotto.domain;

public class Purchase {
    private static final int PRICE_PER_PIECE = 1000;
    private final int amount;
    private final int manualCount;

    public Purchase(int amount, int manualCount) {
        validateAmount(amount);
        this.amount = amount;

        validateManuaulCount(manualCount);
        this.manualCount = manualCount;
    }

    private void validateAmount(int price) {
        if (price < PRICE_PER_PIECE) {
            throw new IllegalArgumentException("구입 금액은 1000원 이상이어야 합니다.");
        }
    }

    private void validateManuaulCount(int manualCount) {
        if (amount < manualLottoAmount(manualCount)) {
            throw new IllegalArgumentException("수동 구입 로또가 구입금액 보다 많습니다.");
        }
    }

    private int manualLottoAmount(int manualCount) {
        return PRICE_PER_PIECE * manualCount;
    }

    public int countOfAuto() {
        return lottoCount() - manualCount;
    }

    private int lottoCount() {
        return Math.floorDiv(amount, PRICE_PER_PIECE);
    }
}
