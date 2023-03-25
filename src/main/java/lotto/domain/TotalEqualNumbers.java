package lotto.domain;

import lotto.service.BuyLotto;

import java.util.Iterator;

public class TotalEqualNumbers {

    private int equalsNumberCount3;
    private int equalsNumberCount4;
    private int equalsNumberCount5;
    private int equalsNumberCountBonus5;
    private int equalsNumberCount6;
    private float totalWinAmout;

    public TotalEqualNumbers(BuyLotto buyLotto, WinOfLotto winOfLotto) {
        Iterator<Lotto> iterator = buyLotto.getLottos().getLottos().iterator();

        while (iterator.hasNext()) {
            Lotto lotto = iterator.next();

            EqualNumbers equalNumbers = new EqualNumbers(lotto, winOfLotto);

            equalNumbers.getEqualCount();
            equalNumbers.getBoABoolean();

            setTotalEqualNumber(equalNumbers);
        }
    }

    public void setTotalEqualNumber(EqualNumbers equalNumbers) {

        float winOfMoney = 0;

        if (equalNumbers.getEqualCount() == 3) {
            this.equalsNumberCount3++;
            winOfMoney = EqualNumbersMoney.EQUALS_3.getWinOfMoney();
        }

        if (equalNumbers.getEqualCount() == 4) {
            this.equalsNumberCount4++;
            winOfMoney = EqualNumbersMoney.EQUALS_4.getWinOfMoney();
        }

        if (equalNumbers.getEqualCount() == 5
                && equalNumbers.getBoABoolean() == false) {
            this.equalsNumberCount5++;
            winOfMoney = EqualNumbersMoney.EQUALS_5.getWinOfMoney();
        }

        if (equalNumbers.getEqualCount() == 5
                && equalNumbers.getBoABoolean() == true) {
            this.equalsNumberCountBonus5++;
            winOfMoney = EqualNumbersMoney.EQUALS_5_BONUS.getWinOfMoney();
        }

        if (equalNumbers.getEqualCount() == 6) {
            this.equalsNumberCount6++;
            winOfMoney = EqualNumbersMoney.EQUALS_6.getWinOfMoney();
        }

        this.totalWinAmout += winOfMoney;
    }

    public int getEqualsNumberCount3() {
        return this.equalsNumberCount3;
    }

    public int getEqualsNumberCount4() {
        return this.equalsNumberCount4;
    }

    public int getEqualsNumberCount5() {
        return this.equalsNumberCount5;
    }

    public int getEqualsNumberCountBonus5() {
        return this.equalsNumberCountBonus5;
    }

    public int getEqualsNumberCount6() {
        return this.equalsNumberCount6;
    }

    public float getTotalWinAmout() {
        return this.totalWinAmout;
    }
}
