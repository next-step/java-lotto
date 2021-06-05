package lotto.model;

public enum WinningResult {
    FIFTH_PRICE(5_000),
    FOURTH_PRICE(50_000),
    THIRD_PRICE(1_500_000),
    SECOND_PRICE(30_000_000),
    FIRST_PRICE(2_000_000_000);

    private int winningAmount;
    private int[] numberOfWins ;

    WinningResult(int winningAmount) {
        this.winningAmount = winningAmount;
        numberOfWins = new int[5];
    }

    public void addNumberOfWinning(int numberOfWinningNumbers, boolean existenceOfBonusNumber) {
        if (numberOfWinningNumbers == 3) {
            numberOfWins[0]++;
        }

        if (numberOfWinningNumbers == 4) {
            numberOfWins[1]++;
        }

        if (numberOfWinningNumbers == 5 && !existenceOfBonusNumber) {
            numberOfWins[2]++;
        }

        if (numberOfWinningNumbers == 5 && existenceOfBonusNumber) {
            numberOfWins[3]++;
        }

        if (numberOfWinningNumbers == 6) {
            numberOfWins[4]++;
        }
    }

    public int calculateEarningPrice() {
        return FIFTH_PRICE.getWinningAmount() * numberOfWins[0]
                + FOURTH_PRICE.getWinningAmount() * numberOfWins[1]
                + THIRD_PRICE.getWinningAmount() * numberOfWins[2]
                + SECOND_PRICE.getWinningAmount() * numberOfWins[3]
                + FIRST_PRICE.getWinningAmount() * numberOfWins[4];
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public int[] getNumberOfWins() {
        return numberOfWins;
    }
}
