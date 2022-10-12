package lotto.views;

import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import lotto.domains.Lotto;
import lotto.domains.LottoGenerator;
import lotto.domains.Prize;

public class ResultView {
    private final List<Lotto> lottos;
    private final Lotto lastWinner;

    public ResultView(List<Lotto> lottos, Lotto lastWinner) {
        this.lottos = lottos;
        this.lastWinner = lastWinner;
    }

    public void printStatistics() {
        System.out.println("당첨 통계");
        System.out.println("---------");

        Map<Prize, Long> prizeCountMap = getCountEachPrize();
        printCountEachPrize(prizeCountMap);

        long totalPurchased = lottos.size() * LottoGenerator.LOTTO_PRICE;
        long totalReward = getTotalReward(prizeCountMap);
        double yield = totalReward / (double) totalPurchased;

        System.out.printf("총 수익률은 %.2f입니다.\n", yield);
    }

    private long getTotalReward(Map<Prize, Long> prizeCountMap) {
        return prizeCountMap.entrySet()
                .stream()
                .mapToLong(e -> e.getKey().getReward() * e.getValue())
                .reduce(Long::sum)
                .orElse(0L);
    }

    private void printCountEachPrize(Map<Prize, Long> prizeCountMap) {
        LongStream.rangeClosed(3, 6).boxed()
                .forEach(correctCount -> printPrize(correctCount, prizeCountMap));
    }

    private Map<Prize, Long> getCountEachPrize() {
        Map<Prize, Long> prizeCountMap = lottos.stream()
                .map(lotto -> lotto.getPrize(lastWinner))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return prizeCountMap;
    }

    private BinaryOperator<Long> sumPrize(Map<Prize, Long> prizeCountMap) {
        return (n1, n2) -> {
            long r1 = prizeCountMap.getOrDefault(n1, 0L) * Prize.find(n1).getReward();
            long r2 = prizeCountMap.getOrDefault(n2, 0L) * Prize.find(n2).getReward();

            return r1 + r2;
        };
    }

    private void printPrize(long correctCount, Map<Prize, Long> prizeCountMap) {
        Prize prize = Prize.find(correctCount);
        prizeCountMap.get(prize);

        System.out.printf("%d개 일치 (%d원)- %d개\n",
                prize.getCorrectCount(),
                prize.getReward(),
                prizeCountMap.getOrDefault(prize, 0L));
    }
}
