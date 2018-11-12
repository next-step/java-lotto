package lotto.domain;

import lotto.enums.Rank;

public class LottoDto {
    Rank rank;
    private int matchNumber;
    private int winningMoney;

    public LottoDto(Rank rank, int matchNumber, int winningMoney) {
        this.rank = rank;
        this.matchNumber = matchNumber;
        this.winningMoney = winningMoney;
    }

    public int getDefaultMoney() {
        return rank.getWinningMoney();
    }

    public int getWinnerCategory() {
        return rank.getCountOfMatch();
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}
