package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.LottoStatistic;

import java.util.Arrays;
import java.util.List;

/**
 * Created by seungwoo.song on 2022-10-06
 */
public class LottoResultView {

    public void print(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }
    public void print(LottoStatistic lottoStatistic) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        Arrays.stream(LottoResult.values())
                .forEach((lottoResult -> {
                    System.out.println(String.format("%d개 일치 (%d)%s)- %d개",
                            lottoResult.getMatchCount(),
                            lottoResult.getMoney(),
                            lottoResult.getUnitDescription(),
                            getCount(lottoStatistic, lottoResult)));
                }));

        System.out.println(getReveneMessage(lottoStatistic));
    }

    private String getReveneMessage(LottoStatistic lottoStatistic) {
        String msg = String.format("총 수익률은 %.2f입니다.", lottoStatistic.getRevenue());
        if (lottoStatistic.isLost()) {
            msg = msg + "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
        }
        return msg;
    }

    private Integer getCount(LottoStatistic lottoStatistic, LottoResult lottoResult) {
        return lottoStatistic.getLottoResultCounter().getOrDefault(lottoResult, 0);
    }
}
