package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;
    private List<Integer> winningResult = new ArrayList<>();

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    int fifth = 0;
    int fourth = 0;
    int third = 0;
    int second = 0;
    int first = 0;

    public void countWinningResults(Lotto winningNumbers, int bonusNumber) {
        for (Lotto lotto : lottos) {
            int numberOfWinningNumbers = lotto.countWinningNumbers(winningNumbers);
            boolean existenceOfBonusNumber = lotto.contains(bonusNumber);
            addNumberOfWinning(numberOfWinningNumbers, existenceOfBonusNumber);
        }
        winningResult.add(fifth);
        winningResult.add(fourth);
        winningResult.add(third);
        winningResult.add(second);
        winningResult.add(first);
    }

    private void addNumberOfWinning(int numberOfWinningNumbers, boolean existenceOfBonusNumber) {
        if (numberOfWinningNumbers == 3) {
            fifth++;
        }

        if (numberOfWinningNumbers == 4) {
            fourth++;
        }

        if (numberOfWinningNumbers == 5 && !existenceOfBonusNumber) {
            third++;
        }

        if (numberOfWinningNumbers == 5 && existenceOfBonusNumber) {
            second++;
        }

        if (numberOfWinningNumbers == 6) {
            first++;
        }
    }

    public float calculateEarningRate(int purchasePrice) {
        int earningPrice = calculateEarningPrice();
        return (float) earningPrice / (float) purchasePrice;
    }

    private int calculateEarningPrice() {
        return WinningResult.FIFTH_PRICE.getPrice() * fifth
                + WinningResult.FOURTH_PRICE.getPrice() * fourth
                + WinningResult.THIRD_PRICE.getPrice() * third
                + WinningResult.SECOND_PRICE.getPrice() * second
                + WinningResult.FIRST_PRICE.getPrice() * first;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public List<Integer> getWinningResults() {
        return winningResult;
    }
}
