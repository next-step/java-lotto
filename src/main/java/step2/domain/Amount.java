package step2.domain;

public class Amount {

    private final int lottoAmount;

    public Amount(int lottoAmount) {
        this.lottoAmount = lottoAmount;
        purchaseAmountValidate();
    }

    public int getLottoAmount() {
        return lottoAmount;
    }

    private void purchaseAmountValidate() {
        if (this.lottoAmount == 0) {
            throw new IllegalArgumentException("구입 금액 값이 없습니다.");
        }

        if (this.lottoAmount < 1000) {
            throw new IllegalArgumentException("구입 금액은 1000원부터 입력가능합니다.");
        }

        if (this.lottoAmount > 100000) {
            throw new IllegalArgumentException("로또는 10만원 이상 구매불가합니다.");
        }
    }
}
