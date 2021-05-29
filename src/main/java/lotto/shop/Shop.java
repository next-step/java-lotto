package lotto.shop;

import lotto.error.ErrorMessage;
import lotto.lotto.LottoNumber;
import lotto.lotto.WinningNumber;
import lotto.lotto.Lotto;
import lotto.lotto.LottoTicket;
import lotto.lotto.LottoResult;

public class Shop {
    private static final int PURCHASE_PRICE = 1000;

    public Money buySelfLotto(Money money, int amount) {
        checkMoney(money);
        return purchase(money, amount);
    }

    public LottoTicket buyAutoLotto(LottoTicket lottoTicket, Money money) {
        checkMoney(money);
        return selectAuto(lottoTicket, money.amount() / PURCHASE_PRICE);
    }

    private Money purchase(Money money, int amount) {
        checkMoney(money);
        return new Money(calculate(money, amount));
    }

    private LottoTicket selectAuto(LottoTicket lottoTicket, int amount) {
        for (int i = 0; i < amount; i++) {
            lottoTicket.add(createAutoLotto());
        }
        return lottoTicket;
    }

    public void checkDuplicateBonusNumber(WinningNumber winningNumber, LottoNumber bonusNumber) {
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_BONUS_NUMBER);
        }
    }

    public LottoResult lottoResult(LottoTicket lottoTicket, WinningNumber winningNumber, LottoNumber bonusNumber) {
        return lottoTicket.matchWinningNumber(winningNumber, bonusNumber);
    }

    private void checkMoney(Money money) {
        if (money.amount() < PURCHASE_PRICE) {
            throw new RuntimeException(ErrorMessage.NOT_ENOUGH_MONEY);
        }
    }

    private void checkMoney(Money money, int amount) {
        if (money.amount() < amount * PURCHASE_PRICE) {
            throw new RuntimeException(ErrorMessage.NOT_ENOUGH_MONEY);
        }
    }

    private Lotto createAutoLotto() {
        return generateNumber();
    }

    private Lotto generateNumber() {
        return new Lotto(NumberGenerator.generate());
    }

    private int calculate(Money money, int amount) {
        checkMoney(money, amount);
        return money.amount() - amount * PURCHASE_PRICE;
    }
}