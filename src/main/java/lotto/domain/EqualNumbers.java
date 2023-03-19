package lotto.domain;

import lotto.service.BuyLotto;

import java.util.HashSet;
import java.util.Set;

public class EqualNumbers {
    private int equal3;
    private int equal4;
    private int equal5;
    private int equal5_bonus;
    private int equal6;
    private long totalWinAmt;

    public EqualNumbers(BuyLotto buyLotto, WinOfLotto winOfLotto) {

        for (int i = 0; i < buyLotto.getCount(); i++) {

            Set<Integer> winNumbers = new HashSet<>();

            winNumbers.addAll(buyLotto.getNumbers(i));
            winNumbers.retainAll(winOfLotto.getNumbers());

            switch (winNumbers.size()) {
                case 3:
                    this.equal3++;
                    this.totalWinAmt += EqualNumbersMoney.EQUALS_3.getWinOfMoney();
                    break;
                case 4:
                    this.equal4++;
                    this.totalWinAmt += EqualNumbersMoney.EQUALS_4.getWinOfMoney();
                    break;
                case 5:
                    if (winOfLotto.containBonusNumber(buyLotto.getNumbers(i))) {
                        this.equal5_bonus++;
                        this.totalWinAmt += EqualNumbersMoney.EQUALS_5_BONUS.getWinOfMoney();
                    } else {
                        this.equal5++;
                        this.totalWinAmt += EqualNumbersMoney.EQUALS_5.getWinOfMoney();
                    }
                    break;
                case 6:
                    this.equal6++;
                    this.totalWinAmt += EqualNumbersMoney.EQUALS_6.getWinOfMoney();
                    break;
            }
        }
    }

    public int getEqual3() {
        return this.equal3;
    }

    public int getEqual4() {
        return this.equal4;
    }

    public int getEqual5() {
        return this.equal5;
    }

    public int getEqual5_bonus() {
        return this.equal5_bonus;
    }

    public int getEqual6() {
        return this.equal6;
    }

    public long getTotalWinAmt() {
        return this.totalWinAmt;
    }
}
