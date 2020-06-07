package study.step3.domain;

public class LottoResult {
    private WinningRanks winningRanks;
    private double earningRate;

    public LottoResult(WinningRanks winningRanks){
        this(winningRanks, winningRanks.calculateEarningsRate());
    }

    public LottoResult(WinningRanks winningRanks, double earningRate) {
        this.winningRanks = winningRanks;
        this.earningRate = earningRate;
    }

    public double getEarningRate() {
        return earningRate;
    }

    public long countRank(WinningRank rank) {
        return winningRanks.getWinningRanks()
                           .stream()
                           .filter(winningRank -> winningRank.equals(rank))
                           .count();
    }
}
