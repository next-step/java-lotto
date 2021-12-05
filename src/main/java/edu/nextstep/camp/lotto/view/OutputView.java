package edu.nextstep.camp.lotto.view;

import java.util.Map;
import java.util.stream.Collectors;

import edu.nextstep.camp.lotto.domain.Lotto;
import edu.nextstep.camp.lotto.domain.LottoNumber;
import edu.nextstep.camp.lotto.domain.Lottos;
import edu.nextstep.camp.lotto.domain.Prize;
import edu.nextstep.camp.lotto.domain.Rank;

public class OutputView {
    private OutputView() {
    }

    public static void printPurchasedLotto(Lottos purchaseList) {
        System.out.printf("%d장을 구입했습니다.\n", purchaseList.amount());

        for (Lotto lotto : purchaseList.collect()) {
            final String numbers = lotto.collect()
                    .stream()
                    .map(LottoNumber::toString)
                    .collect(Collectors.joining(","));
            System.out.println("[" + numbers + "]");
        }
    }

    public static void printGameResult(Map<Rank, Long> ranks, long totalPrize, float earningRate) {
        final long noRank = 0L;
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (" + Prize.FIFTH_PRIZE + "원)-" + ranks.getOrDefault(Rank.FIFTH, noRank));
        System.out.println("4개 일치 (" + Prize.FOURTH_PRIZE + "원)-" + ranks.getOrDefault(Rank.FOURTH, noRank));
        System.out.println("5개 일치 (" + Prize.THIRD_PRIZE + "원)-" + ranks.getOrDefault(Rank.THIRD, noRank));
        System.out.println("5개 일치, 보너스 번호 일치 (" + Prize.SECOND_PRIZE + "원)-" + ranks.getOrDefault(Rank.SECOND, noRank));
        System.out.println("6개 일치 (" + Prize.FIRST_PRIZE + "원)-" + ranks.getOrDefault(Rank.FIRST, noRank));
        System.out.println("총 상금: " + totalPrize);
        System.out.println("총 수익률은 " + earningRate + "입니다.");
    }
}
