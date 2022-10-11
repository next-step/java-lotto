package lotto.view;

import lotto.domain.Lotto;

import java.io.PrintStream;
import java.util.List;

public class OutputView {

    private static final PrintStream OUTPUT = System.out;

    private OutputView() {
    }

    public static void printGeneratedLottos(List<Lotto> lottos) {
        OUTPUT.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(OUTPUT::println);
    }
}
