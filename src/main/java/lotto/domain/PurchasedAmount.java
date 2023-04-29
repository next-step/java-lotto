package lotto.domain;

public class PurchasedAmount {

    public static final int LOTTO_PRICE = 1_000;

    private final int availableLottoCount;
    private final int availableAutoLottoCount;
    private final int availableManualLottoCount;

    public PurchasedAmount(int amount) {
        this(amount, 0);
    }

    public PurchasedAmount(int amount, int manualLottoCount) {
        validateAmount(amount);
        this.availableLottoCount = amount / LOTTO_PRICE;
        this.availableManualLottoCount = manualLottoCount;
        this.availableAutoLottoCount = availableLottoCount - manualLottoCount;
        validateCount();
    }

    private void validateAmount(int value) {
        if (value < LOTTO_PRICE) {
            throw new IllegalArgumentException(String.format("최소 구매입력은 %d원 이상입니다.", LOTTO_PRICE));
        }
    }

    private void validateCount() {
        if (availableLottoCount < availableManualLottoCount) {
            throw new IllegalArgumentException(
                    String.format("수동으로 구입가능한 로또는 %d개 이하입니다.", availableAutoLottoCount));
        }
    }

    public int getAvailableAutoLottoCount() {
        return availableAutoLottoCount;
    }

    public int getAvailableManualLottoCount() {
        return availableManualLottoCount;
    }
    
}