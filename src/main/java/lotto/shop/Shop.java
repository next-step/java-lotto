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

    public LottoTicket selectAuto(int amount) {
        LottoTicket lottoTicket = new LottoTicket();
        for (int i = 0; i < amount; i++) {
            lottoTicket.add(createAutoLotto());
        }
        return lottoTicket;
    }

    public Map<Integer, Integer> matchAnswer(LottoTicket lottoTicket, Set<Integer> answer) {
        Map<Integer, Integer> match = new HashMap<>();
        lottoTicket.tickets().forEach(lotto -> {
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