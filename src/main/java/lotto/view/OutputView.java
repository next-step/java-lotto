package lotto.view;

import java.util.List;

import lotto.domain.Lotto;

public class OutputView {
    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println("[" + printLotto(lotto) + "]");
        }
    }

    private static String printLotto(Lotto lotto) {
        return String.join(",", lotto.getLottoNumbers().stream()
            .map(String::valueOf)
            .sorted()
            .toArray(String[]::new)
        );
    }
}
