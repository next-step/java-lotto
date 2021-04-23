package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.Rank;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {
    public void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개 구매했습니다.");
    }

    public void printLottos(Lottos lottos) {
        lottos.getLottos().stream()
                .forEach(lotto -> printLotto(lotto));
    }

    private void printLotto(Lotto lotto) {
        String lottoNumbers = lotto.getLottoNumbers().stream()
                                    .map(Object::toString)
                                    .collect(Collectors.joining(", "));
        System.out.println("[" + lottoNumbers+ "]");
    }

    public void printLottoRank(Map<Rank, Integer> lottoPrizeMap, Money money) {
        System.out.println("===당첨통계===");

        Arrays.stream(Rank.values())
                .filter(rank -> !rank.equals(Rank.NOT_MATCH) && lottoPrizeMap.get(rank) != 0)
                .forEach(rank -> printRank(rank, lottoPrizeMap));

         System.out.println("총 수익률: " + money.revenueRate(lottoPrizeMap));
    }

    private void printRank(Rank rank, Map<Rank, Integer> lottoPrizeMap) {
        System.out.println(getRankMessage(rank) + " " + lottoPrizeMap.get(rank) + "개");
    }

    private String getRankMessage(Rank rank) {
        if (Rank.FIRST == rank)
            return "6개 일치 (2,000,000,000원)";

        if (Rank.SECOND == rank)
            return "5개 일치 (30,000,000원)";

        if (Rank.THIRD == rank)
            return "4개 일치 (1,500,000원)";

        if (Rank.FOURTH == rank)
            return "3개 일치 (50,000원)";

        if (Rank.FIFTH == rank)
            return "2개 일치 (5,000원)";

        return "";
    }
}
