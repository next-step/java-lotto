package lotto.view;

import lotto.model.Lottos;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private static final String OUTPUT_BUYING_LOTTOS = "%d개를 구매했습니다.";
    private static final String DELIMITER = ", ";
    private static final String OUTPUT_OPEN_BRACKET = "[";
    private static final String OUTPUT_CLOSE_BRACKET = "]";

    private ResultView() {
        throw new AssertionError();
    }

    public static void printBuyingLottos(List<Lottos> buyingLottos) {
        System.out.println(String.format(OUTPUT_BUYING_LOTTOS, buyingLottos.size()));

        for (Lottos lottos : buyingLottos) {
            printLottos(lottos);
        }
        System.lineSeparator();
    }

    private static void printLottos(Lottos lottos) {
        StringBuilder sb = new StringBuilder();
        sb.append(OUTPUT_OPEN_BRACKET);
        sb.append(lottos.get()
                .stream()
                .map(num -> String.valueOf(num))
                .collect(Collectors.joining(DELIMITER)));
        sb.append(OUTPUT_CLOSE_BRACKET);
        System.out.println(sb);
    }
}
