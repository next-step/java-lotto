package lotto.domain;

public class LottoAmount {

    private int amount;

    // TODO: 1000원 단위로 금액을 입력받는다, 숫자만 입력할 수 있다.
    public LottoAmount(String amount) {

        int value = Integer.parseInt(amount);
        this.amount = value;
    }
}
