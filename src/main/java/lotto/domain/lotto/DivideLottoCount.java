package lotto.domain.lotto;

public class DivideLottoCount implements CountableLotto{

    @Override
    public int countLotto(Money money) {
        return money.amount() / Lotto.PURCHASE_UNIT;
    }
}
