package lotto.view;

import java.util.List;
import lotto.domain.LottoLine;
import lotto.domain.LottoMatchResult;
import lotto.domain.LottoPaper;
import lotto.domain.Rank;

public class OutputView {

    public void printLottoPaper(LottoPaper lottoPaper) {
        List<LottoLine> manualLottoLines = lottoPaper.getManualLottoLines();
        List<LottoLine> autoLottoLines = lottoPaper.getAutoLottoLines();

        final String countMessage = String
            .format("\n수동으로 %d장, 자동으로 %d개를 구매했습니다.", manualLottoLines.size(),
                autoLottoLines.size());
        System.out.println(countMessage);

        autoLottoLines.forEach(lottoLine -> printLotto(lottoLine));
        manualLottoLines.forEach(lottoLine -> printLotto(lottoLine));
        System.out.println();
    }

    public void printLottoResult(LottoMatchResult result) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");

        Rank.rankValues().forEach(lottoMatch -> {
            String matchMessage = String.format("%s개 일치 (%d원)- %d개", lottoMatch.getCountOfMatch(),
                lottoMatch.getWinningMoney(), result.get(lottoMatch));
            System.out.println(matchMessage);
        });

        double rate = result.computeProfitRate();

        System.out.println(String.format("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)", rate,
            rate >= 1.0f ? "이익" : "손해"));
    }

    private void printLotto(LottoLine lottoLine) {
        List<Integer> nums = lottoLine.getNums();
        System.out.println(nums);
    }
}
