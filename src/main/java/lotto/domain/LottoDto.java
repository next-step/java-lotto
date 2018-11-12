package lotto.domain;

public class LottoDto {
    private int winnerCategory;
    private int defaultMoney;
    private int matchNumber;
    private int winningMoney;

    public LottoDto(int winnerCategory, int defaultMoney, int matchNumber, int winningMoney) {
        this.winnerCategory = winnerCategory;
        this.defaultMoney = defaultMoney;
        this.matchNumber = matchNumber;
        this.winningMoney = winningMoney;
    }

    public int getDefaultMoney() {
        return defaultMoney;
    }

    public int getWinnerCategory() {
        return winnerCategory;
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}
