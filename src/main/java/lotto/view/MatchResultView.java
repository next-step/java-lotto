package lotto.view;

import lotto.domain.Game;
import lotto.domain.PositiveNumber;
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

    public void printRanks() {
        System.out.println("당첨 통계");
        System.out.println("---------");

        printRankInfo(matchedRanks, LottoRank.FIFTH);
        printRankInfo(matchedRanks, LottoRank.FOURTH);
        printRankInfo(matchedRanks, LottoRank.THIRD);
        printRankInfo(matchedRanks, LottoRank.SECOND);
        printRankInfo(matchedRanks, LottoRank.FIRST);
    }

    public void printYields() {
        PositiveNumber reward = matchedRanks.sumReward();
        PositiveNumber totalPrice = game.totalPriceOfTickets();

        LottoYield lottoYield = new LottoYield(reward, totalPrice);

        System.out.println(format("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)", lottoYield.calc()));
    }

    private void printRankInfo(LottoRanks ranks, LottoRank from) {
        String format = "%d개 일치 (%d원)- %d개";
        if(from.isBonusMatched()) {
            format = "%d개 일치, 보너스 볼 일치 (%d원)- %d개";
        }

        System.out.println(format(format, from.getCountOfMatched(), from.getAmount(), ranks.countOf(from)));
    }
}
