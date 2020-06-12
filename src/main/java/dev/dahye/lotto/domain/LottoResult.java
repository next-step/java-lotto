package dev.dahye.lotto.domain;

import java.util.List;

public class LottoResult {
    private final LottoTickets lottoTickets;
    private final Winning winning;

    public LottoResult(LottoTickets lottoTickets, Winning winning) {
        isNotNull(lottoTickets, winning);
        this.lottoTickets = lottoTickets;
        this.winning = winning;
    }

    private void isNotNull(LottoTickets lottoTickets, Winning winning) {
        if (lottoTickets == null || winning == null) {
            throw new IllegalArgumentException("LottoResult를 생성할 수 없습니다.");
        }
    }

    public List<Rank> getMyRanks() {
        return this.lottoTickets.rankings(winning);
    }

    public int getTotalCountOf(Rank target) {
        return (int) this.getMyRanks().stream()
                .filter(rank -> rank == target)
                .count();
    }

    public double getMyWinningRate(LottoMoney lottoMoney) {
        LottoMoney totalPrize = calculateTotalPrize();

        return lottoMoney.divideBy(totalPrize);
    }

    public LottoMoney calculateTotalPrize() {
        int totalPrize = 0;

        for (Rank rank : this.getMyRanks()) {
            totalPrize += rank.getPrize();
        }

        return new LottoMoney(totalPrize);
    }
}
