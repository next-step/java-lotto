package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.LottoStatistic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by seungwoo.song on 2022-10-06
 */
public class LottoResultView {

    public void print(List<Lotto> lottos) {
        lottos.stream().forEach(System.out::println);
    }

    public void print(LottoStatistic lottoStatistic) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        Arrays.stream(LottoResult.values())
                .filter(lottoResult -> lottoResult != LottoResult.NONE)
                .sorted(Comparator.reverseOrder())
                .forEach((lottoResult -> System.out.println(String.format("%s (%s)- %d개",
                        lottoResult.getDescription(),
                        getFormattedMoney(lottoResult),
                        getCount(lottoStatistic, lottoResult)))));

        System.out.println(getRevenueMessage(lottoStatistic));
    }

    private String getFormattedMoney(LottoResult lottoResult) {
        return String.format("%d원", lottoResult.getMoney());
    }

    private Integer getCount(LottoStatistic lottoStatistic, LottoResult lottoResult) {
        return lottoStatistic.getLottoResultCounter().getOrDefault(lottoResult, 0);
    }

    private String getRevenueMessage(LottoStatistic lottoStatistic) {
        String msg = String.format("총 수익률은 %.2f입니다.", lottoStatistic.getRevenue());
        if (lottoStatistic.isLost()) {
            msg = msg + "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
        }
        return msg;
    }
}
