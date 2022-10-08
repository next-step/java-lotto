package Lotto.view;

import Lotto.model.Lotto;
import Lotto.model.LottoNumber;
import Lotto.model.Lottos;
import Lotto.model.Rank;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoOutput {

    private static final String NOTICE_BUY_LOTTO_MESSAGE = "개를 구매했습니다.";
    private static final String ENTER = "\n";
    private static final String DELIMITER = ", ";
    private static final String LOTTO_RESULT_MESSAGE = "당첨 통계";
    private static final int DEFAULT_VALUE = 0;

    public static void noticeBuyLotto(Lottos lottos) {
        List<Lotto> Lottos = lottos.getLottos();
        System.out.println(Lottos.size() + NOTICE_BUY_LOTTO_MESSAGE);
        for (Lotto lotto : Lottos) {
            List<LottoNumber> lottoNumbers = lotto.getLotto();
            System.out.printf("[%s]" + ENTER, lottoNumbers.stream().map(LottoNumber::toString).collect(Collectors.joining(DELIMITER)));
        }
    }

    public static void noticeResult(Map<Rank, Integer> countingRank, double profit) {
        System.out.println(LOTTO_RESULT_MESSAGE);
        System.out.println("------------");
        List<Rank> ranks = List.of(Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST);
        for (Rank rank : ranks) {
            System.out.println(convertToString(rank, countingRank.getOrDefault(rank, DEFAULT_VALUE)));
        }
        System.out.printf("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)", profit);
    }

    private static String convertToString(Rank rank, int countNumber) {
        return String.format("%d개 일치 %d원 -%d개", rank.getMatchCount(), rank.getReward(), countNumber);
    }

}
