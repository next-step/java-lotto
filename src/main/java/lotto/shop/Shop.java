package lotto.shop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lotto.common.ErrorMessage;
import lotto.lotto.Lotto;

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

    public Map<Integer, Integer> matchAnswer(List<Lotto> lottoBundle, Set<Integer> answer) {
        Map<Integer, Integer> match = new HashMap<>();
        lottoBundle.forEach(lotto -> {
            lotto.numbers().retainAll(answer);
            int size = lotto.numbers().size();
            int count = match.getOrDefault(size, 0);
            match.put(size, ++count);
        });
        return match;
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