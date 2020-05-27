package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private ResultView() {}

    public static void printLottos(Lottos lottos) {
        System.out.println(String.format("%d개를 구입했습니다.", lottos.size()));

        for (int i = 0; i < lottos.size(); i++) {
            printLotto(lottos.get(i));
        }
    }

    private static void printLotto(Lotto lotto) {
                List<String> numbers = lotto.getNumbers().stream()
                        .map(String::valueOf)
                        .collect(Collectors.toList());

        String numbersStr = String.join(",", numbers);
        System.out.println(String.format("[%s]", numbersStr));
    }
}
