package lottoGame;

public enum WinningNumbers {
    FOURTH(3, 5000),
    THIRD(4, 50000),
    SECOND(5, 1500000),
    FIRST(6, 2000000000);

    private Integer numberOfWins;
    private Integer winnings;

    WinningNumbers(Integer numberOfWins, Integer winnings) {
        this.numberOfWins = numberOfWins;
        this.winnings = winnings;
    }

    public Integer getNumberOfWins() {
        return numberOfWins;
    }

    public Integer getWinnings() {
        return winnings;
    }

}
