package lotto.model;

import lotto.model.constants.Dividend;

import java.util.Collections;
import java.util.List;

public class Lottery {
    private final List<Integer> winnerNumbers;
    private final List<Lotto> lottos;

    public Lottery(List<Integer> winnerNumbers, List<Lotto> lottos) {
        this.winnerNumbers = winnerNumbers;
        this.lottos = Collections.unmodifiableList(lottos);
    }

    public long depositTotalMoney(){
        long totalMoney = 0;
        for (int i = 3; i <= 6; i++) {
            totalMoney += WinnerMoney.findWinnerMoney(Dividend.getDividend(i), checkForWin(i));
        }
        return totalMoney;
    }
    public double getInvestment(int purchaseAmount) {
        return (double) depositTotalMoney() / purchaseAmount;
    }

    public int checkForWin(int correctCount) {
        return (int) lottos.stream()
                .filter(lotto -> winnerNumbers.stream()
                        .filter(number -> lotto.lottoNumbers().contains(number))
                        .count() == correctCount)
                .count();
    }

}
