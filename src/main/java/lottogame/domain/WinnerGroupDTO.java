package lottogame.domain;

public class WinnerGroupDTO {
    private int matchNum;
    private int prize;
    private int matchCount;

    WinnerGroupDTO(int matchNum, int prize, int matchCount) {
        this.matchNum = matchNum;
        this.prize = prize;
        this.matchCount = matchCount;
    }

    public int getMatchNum() {
        return matchNum;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
