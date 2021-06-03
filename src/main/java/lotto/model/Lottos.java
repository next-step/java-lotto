package lotto.model;

import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void countWinningResults(List<Integer> winningNumbers, int bonusNumber) {
        for (Lotto lotto : lottos) {
            int numberOfWinningNumbers = lotto.countWinningNumbers(winningNumbers);
            boolean existenceOfbonusNumber = lotto.contains(bonusNumber);
            addNumberOfWinning(numberOfWinningNumbers, existenceOfbonusNumber);
        }
    }

    int fifth = 0;
    int fourth = 0;
    int third = 0;
    int second = 0;
    int first = 0;

    public void addNumberOfWinning(int numberOfWinningNumbers, boolean existenceOfbonusNumber) {
        if (numberOfWinningNumbers == 3) {
            fifth++;
        }

        if (numberOfWinningNumbers == 4) {
            fourth++;
        }

        if (numberOfWinningNumbers == 5 && !existenceOfbonusNumber) {
            third++;
        }

        if (numberOfWinningNumbers == 5 && existenceOfbonusNumber) {
            second++;
        }

        if (numberOfWinningNumbers == 6) {
            first++;
        }
    }

    public float getEarningRate(int earningPrice, int purchasePrice) {
        return (float) earningPrice / (float) purchasePrice;
    }

    public int getEarningPrice() {
        return WinningPrice.FIFTH_PRICE.getPrice() * fifth
                + WinningPrice.FOURTH_PRICE.getPrice() * fourth
                + WinningPrice.THIRD_PRICE.getPrice() * third
                + WinningPrice.SECOND_PRICE.getPrice() * second
                + WinningPrice.FIRST_PRICE.getPrice() * first;
    }
}
