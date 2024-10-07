package lotto.step2.domain;

public class LottoMachine {
    private final int PRICE = 1000;

    public int buyLottos(int purchaseAmount) {
        return purchaseAmount / PRICE;
    }
}
