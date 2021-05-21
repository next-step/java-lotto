package lotto.shop;

import lotto.common.ErrorMessage;
import lotto.lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private static final int PURCHASE_PRICE = 1000;

    public int buyLotto(Money money) {
        checkMoney(money);
        return money.amount() / PURCHASE_PRICE;
    }

    public List<Lotto> selectAuto(int amount) {
        List<Lotto> lottoBundle = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            lottoBundle.add(createAutoLotto());
        }
        return lottoBundle;
    }

    private void checkMoney(Money money) {
        if (money.amount() < PURCHASE_PRICE) {
            throw new RuntimeException(ErrorMessage.NOT_ENOUGH_MONEY);
        }
    }

    private Lotto createAutoLotto() {
        Lotto lotto = new Lotto();
        generateNumber(lotto);
        return lotto;
    }

    private void generateNumber(Lotto lotto) {
        while (!lotto.isSelectComplete()) {
            lotto.addNumber(NumberGenerator.generate());
        }
    }
}