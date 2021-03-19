package lotto;

import lotto.domain.*;
import lotto.view.View;

import java.util.List;

public class LottoControl {

    public void play() {
        View view = new View();
        int purchaseAmount = view.purchaseAmount();

        Lotto lotto = new Lotto(purchaseAmount, new RandomLottoNumber());
        view.printBought(lotto.lottoGames());

        WinningNumber winningNumber = new WinningNumber(view.winningNumber());
        List<LottoGameResult> lottoGameResults = lotto.result(winningNumber);

        view.printStatsHead();
        LottoStats lottoStats = new LottoStats(lottoGameResults);
        for (Rank rank : Rank.values()) {
            RankingRecord rankingRecord = lottoStats.record(rank);
            view.print(rank.matchCount(), rank.reward(), rankingRecord.winners());
        }
        view.printYield(lottoStats.yield());
    }
}
