package com.monds.nextstep.lotto.view;

import com.monds.nextstep.lotto.domain.Lotto;
import com.monds.nextstep.lotto.domain.LottoRanking;
import com.monds.nextstep.lotto.domain.LottoResult;
import com.monds.nextstep.lotto.domain.Lottos;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class LottoResultView {

    public static void printLottos(Lottos lottos) {
        System.out.printf("%d개를 구매했습니다.\n", lottos.size());
        List<Lotto> lottoList = lottos.getAll();
        for (Lotto lotto : lottoList) {
            System.out.println(Arrays.toString(lotto.toArray()));
        }
        System.out.println();
    }

    public static void printLottoResult(LottoResult lottoResult) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");

        Map<LottoRanking, Integer> prizeByRanking = lottoResult.getPrizeByRanking();

        Arrays.stream(LottoRanking.values())
              .filter(ranking -> ranking != LottoRanking.NOT_MATCH)
              .forEach(ranking -> printLottoResultRanking(ranking, prizeByRanking));

        System.out.printf("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)", lottoResult.calculateYield());
    }

    private static void printLottoResultRanking(LottoRanking ranking, Map<LottoRanking, Integer> prizeByRanking) {
        Integer count = prizeByRanking.getOrDefault(ranking, 0);
        System.out.printf("%d개 일치 (%d원)- %d개\n", ranking.getCountOfMatch(), ranking.getPrize(), count);
    }
}
