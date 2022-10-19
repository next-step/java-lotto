package lottoGame;

import java.util.Arrays;

public enum WinningRanks {
    NONE(0, 0),
    FOURTH(3, 5000),
    THIRD(4, 50000),
    SECOND(5, 1_500_000),
    FIRST(6, 2_000_000_000);

    private Integer matchNum;
    private Integer winnings;

    WinningRanks(Integer mathNum, Integer winnings) {
        this.matchNum = mathNum;
        this.winnings = winnings;
    }

    public WinningRanks findRank(int matchNum) {
        return Arrays.stream(values())
                .filter(winningRanks -> winningRanks.matchNum == matchNum)
                .findAny()
                .orElse(NONE);
    }

    public Integer getMatchNum() {
        return matchNum;
    }

    public Integer getWinnings() {
        return winnings;
    }

}
