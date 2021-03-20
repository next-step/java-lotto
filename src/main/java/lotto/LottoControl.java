package lotto;

import lotto.domain.*;
import lotto.view.View;

import java.util.List;
import java.util.Scanner;

public class LottoControl {

    public void play() {
        Scanner scanner = new Scanner(System.in);
        int purchaseAmount = View.purchaseAmount(scanner);

        Lotto lotto = new Lotto(purchaseAmount, new RandomLottoNumber());
        View.printBought(lotto.lottoGames());

        WinningNumber winningNumber = new WinningNumber(View.winningNumber(scanner));
        List<LottoGameResult> lottoGameResults = lotto.result(winningNumber);

        View.printStatsHead();
        LottoStats lottoStats = new LottoStats(lottoGameResults);
        for (Rank rank : Rank.values()) {
            RankingRecord rankingRecord = lottoStats.record(rank);
            View.print(rank.matchCount(), rank.reward(), rankingRecord.winners());
        }
        View.printYield(lottoStats.yield());
    }
}
