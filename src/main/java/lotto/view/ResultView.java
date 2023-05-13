package lotto.view;

import lotto.domain.LottoGames;
import lotto.domain.Rank;

import java.util.Map;

public class ResultView {

    private static final String LOTTO_STATISTICS = "\n당첨 통계\n—————————";
    private static final String RETURN_RATE = "총 수익률은 %.2f입니다.";

    public void printLottoResult(LottoGames lottoGames) {
        System.out.println(LOTTO_STATISTICS);
        printMatchedCount(lottoGames);
        printReturnRate(lottoGames);
    }

    private void printMatchedCount(LottoGames lottoGames) {
        Map<Rank, Integer> lottoResult = lottoGames.getLottoResult();
        lottoResult.forEach((rank, winningCount) -> {
            String bonusInfo = rank == Rank.SECOND ? ", 보너스 볼 일치" : "";
            System.out.printf("%d개일치 %s(%d원) - %d\n", rank.getMatchCount(), bonusInfo, rank.getPrize(), winningCount);
        });
    }

    private void printReturnRate(LottoGames lottoGames) {
        System.out.printf(RETURN_RATE, lottoGames.calculateReturn());
    }

    public void printLottoNumbers(LottoGames lottoGames) {
        System.out.println(lottoGames.toString());
    }
}
