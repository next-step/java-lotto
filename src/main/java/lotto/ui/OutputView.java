package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Prize;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;

public class OutputView {

    private OutputView() {
        throw new UnsupportedOperationException();
    }

    public static void printLottos(Lottos lottos, int manualLottoSize, int autoLottoSize) {
        System.out.printf("수동으로 %d장, 자동으로 %d장을 구매했습니다%n", manualLottoSize, autoLottoSize);
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

    public static void printResult(Lottos lottos, Lotto winningLotto, int bonusNumber) {
        System.out.println("당첨 통계");
        System.out.println("----------");

        Map<Prize, Long> matchCountings =
                createMatchCountings(lottos, winningLotto, bonusNumber);

        Arrays.stream(Prize.values())
                        .forEach(prize -> System.out.printf("%d개 일치 (%.0f원) - %d개%n",
                                prize.getMatchCount(),
                                prize.getEarnings(),
                                matchCountings.getOrDefault(prize, 0L)));

        System.out.printf("총 수익률은 %.2f입니다.%n", lottos.earningRate(winningLotto, bonusNumber));
    }

    private static Map<Prize, Long> createMatchCountings(Lottos lottos, Lotto winningLotto, int bonusNumber) {
        return lottos.getLottos()
                .stream()
                .map(lotto -> lotto.findPrize(winningLotto, bonusNumber))
                .collect(Collectors.groupingBy(Function.identity(), counting()));
    }

}
