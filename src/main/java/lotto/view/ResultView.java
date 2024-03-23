package lotto.view;

import lotto.domain.Lotto;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ResultView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void showLottos(List<Lotto> lottos) {
        printLotto(lottos);
    }

    private static void printLotto(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(joinWithDelimiter(lotto));
        }
    }

    private static String joinWithDelimiter(Lotto lotto) {
        return lotto.getValue().stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ","[","]"));
    }
}
