package lotto.model;

import java.util.ArrayList;
import java.util.List;

public enum WinningResult {
    FIFTH_PRICE(5_000),
    FOURTH_PRICE(50_000),
    THIRD_PRICE(1_500_000),
    SECOND_PRICE(30_000_000),
    FIRST_PRICE(2_000_000_000);

    private int winningAmount;
    private List<Integer> numberOfWins;

    WinningResult(int winningAmount) {
        this.winningAmount = winningAmount;
        numberOfWins = new ArrayList<>();
    }

    public void addNumberOfWinning(int numberOfWinningNumbers, boolean existenceOfBonusNumber) {
        int numberOfFifthPlace = 0;
        int numberOfFourthPlace = 0;
        int numberOfThirdPlace = 0;
        int numberOfSecondPlace = 0;
        int numberOfFirstPlace = 0;

        if (numberOfWinningNumbers == 3) {
            numberOfFifthPlace++;
        }

        if (numberOfWinningNumbers == 4) {
            numberOfFourthPlace++;
        }

        if (numberOfWinningNumbers == 5 && !existenceOfBonusNumber) {
            numberOfThirdPlace++;
        }

        if (numberOfWinningNumbers == 5 && existenceOfBonusNumber) {
            numberOfSecondPlace++;
        }

        if (numberOfWinningNumbers == 6) {
            numberOfFirstPlace++;
        }
        numberOfWins.add(numberOfFifthPlace);
        numberOfWins.add(numberOfFourthPlace);
        numberOfWins.add(numberOfThirdPlace);
        numberOfWins.add(numberOfSecondPlace);
        numberOfWins.add(numberOfFirstPlace);
    }

    public int calculateEarningPrice() {
        return FIFTH_PRICE.getWinningAmount() * numberOfWins.get(0)
                + FOURTH_PRICE.getWinningAmount() * numberOfWins.get(1)
                + THIRD_PRICE.getWinningAmount() * numberOfWins.get(2)
                + SECOND_PRICE.getWinningAmount() * numberOfWins.get(3)
                + FIRST_PRICE.getWinningAmount() * numberOfWins.get(4);
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public List<Integer> getNumberOfWins() {
        return numberOfWins;
    }
}
