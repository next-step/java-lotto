package study.lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoResult {
    private Map<LottoRank, Lottos> winningTickets;
    private Amount investmentAmount;

    public LottoResult(Lottos lottos,
                       LottoWinningNumber lottoWinningNumber,
                       Amount investmentAmount) {
        this.investmentAmount = investmentAmount;
        setWinningTickets(lottos, lottoWinningNumber);
    }

    public LottoResult(Lottos lottos,
                       LottoWinningNumber lottoWinningNumber,
                       int investmentAmount) {
        this(lottos, lottoWinningNumber, new Amount(investmentAmount));
    }

    private void setWinningTickets(Lottos lottos,
                                   LottoWinningNumber lottoWinningNumber) {
        initWinningTickets();
        for (Lotto lotto : lottos) {
            LottoRank lottoRank = lottoWinningNumber.rank(lotto);
            this.winningTickets.get(lottoRank).add(lotto);
        }
    }

    private void initWinningTickets() {
        this.winningTickets = new HashMap<>();
        for (LottoRank lottoRank : LottoRank.values()) {
            this.winningTickets.put(lottoRank, new Lottos());
        }
    }

    public Lottos getWinningTickets(LottoRank lottoRank) {
        return new Lottos(winningTickets.get(lottoRank));
    }

    public double getRateOfReturn() {
        int prizeTotal = getPrizeTotal();

        return (double) prizeTotal / investmentAmount.getAmount();
    }

    private int getPrizeTotal() {
        int prizeTotal = 0;

        for (LottoRank lottoRank : LottoRank.values()) {
            prizeTotal += this.winningTickets.get(lottoRank).size() *
                    lottoRank.getPrize();
        }

        return prizeTotal;
    }
}
