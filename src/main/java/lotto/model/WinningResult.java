package lotto.model;

public enum WinningResult {
    NO_PRICE(0, 0),
    FIFTH_PRICE(3, 5_000),
    FOURTH_PRICE(4, 50_000),
    THIRD_PRICE(5, 1_500_000),
    SECOND_PRICE(5, 30_000_000),
    FIRST_PRICE(6, 2_000_000_000);

    private int countOfWinningNumber;
    private int winningAmount;

    WinningResult(int countOfWinningNumber, int winningAmount) {
        this.countOfWinningNumber = countOfWinningNumber;
        this.winningAmount = winningAmount;
    }

    public static WinningResult addNumberOfWinning(int numberOfWinningNumbers, boolean existenceOfBonusNumber) {
        if (numberOfWinningNumbers == SECOND_PRICE.countOfWinningNumber && existenceOfBonusNumber) {
            return SECOND_PRICE;
        }
        for (WinningResult value : values()) {
            if (numberOfWinningNumbers == value.countOfWinningNumber) {
                return value;
            }
        }
        return NO_PRICE;
    }

    public double multiplyWinningAmount(int winningResultNumber) {
        return winningAmount * winningResultNumber;
    }

    public int getCountOfWinningNumber() {
        return countOfWinningNumber;
    }

    public int getWinningAmount() {
        return winningAmount;
    }
}
