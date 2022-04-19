package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.*;
import java.util.function.Function;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static lotto.domain.Lotto.PRIZE;

public class OutputView {

    public static void printLottos(Lottos lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.getLottos()
                .forEach(OutputView::printLotto);
    }

    private static void printLotto(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        Collections.sort(numbers);

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Integer number : numbers) {
            sb.append(number + ", ");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        System.out.println(sb);
    }

    public static void printResult(Lottos lottos, Lotto winningLotto) {
        System.out.println("당첨 통계");
        System.out.println("----------");

        Map<Integer, Long> matchNumberCounting =
                createMatchNumberCounting(lottos, winningLotto);
        Set<Integer> matchNumbers = new TreeSet<>(PRIZE.keySet());

        matchNumbers.forEach(matchNumber -> {
            System.out.printf("%d개 일치 (%.0f원) - %d개\n",
                    matchNumber,
                    PRIZE.get(matchNumber),
                    matchNumberCounting.getOrDefault(matchNumber, 0L));
        });

        System.out.printf("총 수익률은 %.2f입니다.\n", lottos.earningRate(winningLotto));
    }

    private static Map<Integer, Long> createMatchNumberCounting(Lottos lottos, Lotto winningLotto) {
        return lottos.getLottos()
                .stream()
                .map(lotto -> lotto.matchCount(winningLotto))
                .collect(groupingBy(Function.identity(), counting()));
    }

}
