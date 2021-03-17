package lotto.domain;

public class LottoMachine {

    public void buyLotto(int buyAmount) {
        int lottoQuantity = amountToQuantity(buyAmount);
    }

    public int amountToQuantity(int amount) {
        return amount / 1000;
    }
}
