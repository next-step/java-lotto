package lotto.shop;

import lotto.error.ErrorMessage;
import lotto.lotto.LottoNumber;
import lotto.lotto.WinningNumber;
import lotto.lotto.Lotto;
import lotto.lotto.LottoTicket;
import lotto.lotto.LottoResult;

public class Shop {
    private static final int PURCHASE_PRICE = 1000;

    public LottoTicket buyAutoLotto(Money money) {
        checkMoney(money);
        return selectAuto(money.amount() / PURCHASE_PRICE);
    }

    private LottoTicket selectAuto(int amount) {
        LottoTicket lottoTicket = new LottoTicket();
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

    private Lotto createAutoLotto() {
        return generateNumber();
    }

    private Lotto generateNumber() {
        return new Lotto(NumberGenerator.generate());
    }
}