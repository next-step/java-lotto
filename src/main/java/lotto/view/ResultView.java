package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ResultView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void showLottos(Lottos lottos) {
        printLotto(lottos);
    }

    private static void printLotto(Lottos lottos) {
        for (Lotto lotto : lottos.getValue()) {
            System.out.println(joinWithDelimiter(lotto));
        }
    }

    private static String joinWithDelimiter(Lotto lotto) {
        return lotto.getValue().stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ","[","]"));
    }
}
