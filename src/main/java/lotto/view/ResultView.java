package lotto.view;

import lotto.domain.LottoConstant;
import lotto.domain.LottoGames;
import lotto.domain.LottoPrize;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView {

    private static final String LOTTO_STATISTICS = "\n당첨 통계\n—————————";
    private static final String RETURN_RATE = "총 수익률은 %.2f입니다.";
    public void printLottoResult(LottoGames lottoGames) {
        System.out.println(LOTTO_STATISTICS);
        printMatchedCount(lottoGames);
        printReturnRate(lottoGames);
    }

    private void printMatchedCount(LottoGames lottoGames) {
        List<Integer> lottoResult = lottoGames.getLottoResult();
        IntStream.range(LottoConstant.MIN_WINNING_NUM, lottoResult.size())
                .forEach(index -> System.out.printf("%d개일치 (%d원) - %d\n", index, LottoPrize.findPrize(index), lottoResult.get(index)));
    }

    private void printReturnRate(LottoGames lottoGames) {
        System.out.printf(RETURN_RATE, lottoGames.calculateReturn());
    }
}
