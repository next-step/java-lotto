package lotto.view;

import lotto.domain.LottoGames;
import lotto.domain.LottoPrize;

import java.util.stream.IntStream;

public class ResultView {

    public void printLottoResult(LottoGames lottoGames) {
        System.out.println("당첨 통계");
        System.out.println("————");
        printMatchedCount(lottoGames);
        printReturnRate(lottoGames);
    }

    private void printMatchedCount(LottoGames lottoGames) {
        int[] lottoResult = lottoGames.getLottoResult();
        IntStream.range(3, lottoResult.length - 1)
                .forEach(index -> System.out.printf("%d개일치 (%d원) - %d\n", index, LottoPrize.findPrize(index), lottoResult[index]));
    }

    private void printReturnRate(LottoGames lottoGames) {
        System.out.println(lottoGames.calculateReturn());
    }
}
