package lotto.domain;

public class LottoDto {
    private int winnerCategory;
    private int matchNumber;
    private int winningMoney;

    public LottoDto() {

    }

    public LottoDto(int winnerCategory, int matchNumber, int winningMoney) {
        this.winnerCategory = winnerCategory;
        this.matchNumber = matchNumber;
        this.winningMoney = winningMoney;
    }

    public int getWinnerCategory() {
        return winnerCategory;
    }

    public void setWinnerCategory(int winnerCategory) {
        this.winnerCategory = winnerCategory;
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public void setMatchNumber(int matchNumber) {
        this.matchNumber = matchNumber;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public void setWinningMoney(int winningMoney) {
        this.winningMoney = winningMoney;
    }
}
