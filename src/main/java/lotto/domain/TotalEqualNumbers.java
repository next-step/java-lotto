package lotto.domain;

import java.util.Iterator;

public class TotalEqualNumbers {
    public TotalEqualNumbers(BuyLotto buyLotto, WinOfLotto winOfLotto) {
        Iterator<Lotto> iterator = buyLotto.getLottos().getLottos().iterator();

        while (iterator.hasNext()) {
            Lotto lotto = iterator.next();

            EqualNumbers equalNumbers = new EqualNumbers(lotto, winOfLotto);

            setTotalEqualNumber(equalNumbers);
        }
    }

    public void setTotalEqualNumber(EqualNumbers equalNumbers) {
        if (equalNumbers.getEqualCount() == 3) {
            EqualNumbersMoney.EQUALS_3.setEqualCount();
        }

        if (equalNumbers.getEqualCount() == 4) {
            EqualNumbersMoney.EQUALS_4.setEqualCount();
        }

        if (equalNumbers.getEqualCount() == 5
                && !equalNumbers.getBonusEqual()) {
            EqualNumbersMoney.EQUALS_5.setEqualCount();
        }

        if (equalNumbers.getEqualCount() == 5
                && equalNumbers.getBonusEqual()) {
            EqualNumbersMoney.EQUALS_5_BONUS.setEqualCount();
        }

        if (equalNumbers.getEqualCount() == 6) {
            EqualNumbersMoney.EQUALS_6.setEqualCount();
        }
    }
}
