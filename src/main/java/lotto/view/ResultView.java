package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
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

    public void printLottoRank(Map<Rank, Integer> lottoPrizeMap, int price) {
        System.out.println("===당첨통계===");

        Arrays.stream(Rank.values())
                .filter(rank -> !rank.equals(Rank.NOT_MATCH) && lottoPrizeMap.get(rank) != 0)
                .forEach(rank -> printRank(rank, lottoPrizeMap));

         System.out.println("총 수익률: " + getRevenueRate(lottoPrizeMap, price));

    }

    private double getRevenueRate(Map<Rank, Integer> lottoPrizeMap, int price) {
        int totalPrice = lottoPrizeMap.keySet().stream()
                            .filter(prize -> prize != Rank.NOT_MATCH)
                            .mapToInt(prize -> lottoPrizeMap.get(prize) * prize.getPrice())
                            .sum();

        return Math.round((totalPrice/price)*100)/(double) 100;
    }

    private void printRank(Rank rank, Map<Rank, Integer> lottoPrizeMap) {
        System.out.println(rank.getMessage() + " " + lottoPrizeMap.get(rank) + "개");
    }
}
