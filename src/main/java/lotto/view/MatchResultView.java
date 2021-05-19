package lotto.view;

import lotto.domain.Game;
import lotto.domain.PositiveInteger;
import lotto.domain.rank.LottoRank;
import lotto.domain.rank.LottoRanks;

import static java.lang.String.format;

public class MatchResultView {
    private final Game game;
    private final LottoRanks matchedRanks;

    public MatchResultView(Game game, LottoRanks matched) {
        this.game = game;
        this.matchedRanks = matched;
    }

    public void printRanks(LottoRanks match) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        printRankInfo(match, LottoRank.FOURTH);
        printRankInfo(match, LottoRank.THIRD);
        printRankInfo(match, LottoRank.SECOND);
        printRankInfo(match, LottoRank.FIRST);
    }

    public void printYields(LottoRanks match) {
        PositiveInteger reward = match.sumReward();
        PositiveInteger totalPrice = game.totalPriceOfTickets();

        LottoYield lottoYield = new LottoYield(reward, totalPrice);

        System.out.println(format("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)", lottoYield.calc()));
    }

    private void printRankInfo(LottoRanks ranks, LottoRank from) {
        System.out.println(format("%d개 일치 (%d원)- %d개", from.getCountOfMatched(), from.getAmount(), ranks.countOf(from)));
    }
}
