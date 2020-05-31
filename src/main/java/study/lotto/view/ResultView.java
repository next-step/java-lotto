package study.lotto.view;

import study.lotto.model.LottoList;
import study.lotto.model.LottoRank;
import study.lotto.model.Statistics;

import java.util.Arrays;

public class ResultView {

    public void printLottoList(LottoList lottoList) {
        lottoList.getLottoList().forEach(System.out::println);
    }

    public void printStatistics(Statistics statistics) {
        System.out.println("당첨 통계");
        System.out.println("----------");

        Arrays.stream(LottoRank.class.getEnumConstants())
                .filter(LottoRank::isPrizeExists)
                .forEach(lottoRank ->
                    System.out.println(
                            lottoRank + "- "
                            + statistics.getStatistics().get(lottoRank) + "개")
                );

        System.out.println("총 수익률은 " + String.format("%.2f", statistics.getEarningRate()) + "입니다.");
    }
}
