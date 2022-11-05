package step3;

public class LottoAmount {
    private static final int LOTTO_AMOUNT = 1_000;
    private int amount;

    public LottoAmount(int input) {
        if (input < LOTTO_AMOUNT) {
            throw new IllegalArgumentException("최소 금액은 1000원 입니다");
        }
        amount = (input) / LOTTO_AMOUNT;
    }

    public int amountOfLottos() {
        return amount;
    }

    public void checkManualAmount(int manualLottoAmount) {
        if (manualLottoAmount > amountOfLottos()) {
            throw new IllegalArgumentException(amountOfLottos() + "개 초과하여 구매할 수 없습니다.");
        }
    }
}
