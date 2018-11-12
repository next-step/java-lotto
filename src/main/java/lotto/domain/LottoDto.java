package lotto.domain;

import lotto.enums.Rank;

public class LottoDto implements Comparable{
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

    @Override
    public int compareTo(Object obj) {
        LottoDto lottoDto = (LottoDto)obj;
        if (this.rank.getWinningMoney() > lottoDto.rank.getWinningMoney()) {
            return 1;
        }
        if (this.rank.getWinningMoney() < lottoDto.rank.getWinningMoney()) {
            return -1;
        }
        return 0;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
