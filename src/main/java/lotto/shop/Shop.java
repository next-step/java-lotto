package lotto.shop;

import lotto.error.ErrorMessage;
import lotto.lotto.Answer;
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

    public MatchedAnswer matchAnswer(LottoTicket lottoTicket, Answer answer) {
        MatchedAnswer match = new MatchedAnswer();
        lottoTicket.tickets().forEach(lotto -> {
            lotto.numbers().retainAll(answer.numbers());
            match.increaseCount(lotto.numbers().size());
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
            lotto.addNumber(new LottoNumber(NumberGenerator.generate()));
        }
    }
}