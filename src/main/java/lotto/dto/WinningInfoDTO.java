package lotto.dto;

public class WinningInfoDTO {
    private int rank;
    private int winningAmount;

    public WinningInfoDTO(int rank, int winningAmount) {
        this.rank = rank;
        this.winningAmount = winningAmount;
    }

    public int getRank() {
        return rank;
    }

    public int getWinningAmount() {
        return winningAmount;
    }
}
