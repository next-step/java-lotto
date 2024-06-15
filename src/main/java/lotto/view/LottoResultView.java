package lotto.view;

import lotto.dto.LottoResult;
import lotto.entity.Lotto;
import lotto.enums.LottoRank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LottoResultView {
    public void printLottos(List<Lotto> lottos) {
        lottos.forEach(System.out::println);
    }

    public void printResult(LottoResult result, double rateOfReturn) {
        System.out.println("당첨 통계");
        System.out.println("-------");
        printRank(result);
        printRateOfReturn(rateOfReturn);
    }

    private void printRank(LottoResult result) {
        Arrays.stream(LottoRank.values())
                .filter(lottoRank -> LottoRank.NO_RANK != lottoRank)
                .sorted(Comparator.reverseOrder())
                .forEach(rank -> {
                    System.out.printf("%s - %s개\n", rank.getDescription(), result.getCountByRank(rank));
                });
    }

    private void printRateOfReturn(double rateOfReturn) {
        System.out.printf("총 수익률은 %.2f입니다.", rateOfReturn);
        if (rateOfReturn < 1) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임");
        }
    }
}
