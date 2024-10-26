package lotto.view;


import lotto.dto.LottoResultDTO;
import lotto.lotto.*;

import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {

    public static void printResult(LottoResultDTO result) {
        System.out.println("당첨통계");
        System.out.println("============");
        Map<LottoRank, Integer> map = result.getResultMap();
        System.out.println(map.entrySet().stream().map(lottoRankIntegerEntry -> lottoRankIntegerEntry.getKey().getMachingCnt() + "개 일치 ("
                        + lottoRankIntegerEntry.getKey().getWinPrice() + ") - " + lottoRankIntegerEntry.getValue())
                .collect(Collectors.joining(System.lineSeparator())));
        System.out.printf("총 수익률은 %.2f 입니다.", result.getMarginRate());
    }

    public void printCreateLotto(Lottos lottos) {
        System.out.println(lottos.getSize());
        for (int i = 0; i < lottos.getSize(); i++) {
            System.out.println(lottos.getLottos().get(i).toString());
        }
    }
}
