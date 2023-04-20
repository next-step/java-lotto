package lotto.domain;

public class TotalEqualNumbers {
    public void matchNumbers(BuyLotto buyLotto, WinOfLotto winOfLotto) {

        for (Lotto lotto : buyLotto.getLottoNumbers()) {
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
