package lotto;

import lotto.domain.*;
import lotto.view.View;

import java.util.List;
import java.util.Scanner;

public class LottoControl {

    public void play() {
        Scanner scanner = new Scanner(System.in);
        int purchaseAmount = View.purchaseAmount(scanner);

        LottoNumber lottoNumber = new RandomLottoNumber();
        Lotto lotto;
        try {
            lotto = new Lotto(purchaseAmount, lottoNumber);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        View.printBought(lotto.lottoGames());

        WinningNumber winningNumber;
        try {
            winningNumber = new WinningNumber(View.winningNumber(scanner), lottoNumber.min(), lottoNumber.max());
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        List<LottoMatchNumbers> lottoNumberMatches = lotto.result(winningNumber);

        View.printStatsHead();
        LottoStats lottoStats = new LottoStats(lottoNumberMatches);
        for (Rank rank : Rank.values()) {
            RankingRecord rankingRecord = lottoStats.record(rank);
            View.print(rank.matchCount(), rank.reward(), rankingRecord.winners());
        }
        View.printYield(lottoStats.yield());
    }
}
