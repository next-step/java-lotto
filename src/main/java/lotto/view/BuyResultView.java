package lotto.view;

import lotto.model.Lotto;

import java.util.List;
import java.util.stream.Collectors;

public class BuyResultView {

    private static final String OUTPUT_BUYING_LOTTOS = "%d개를 구매했습니다.";
    private static final String DELIMITER = ", ";
    private static final String OUTPUT_OPEN_BRACKET = "[";
    private static final String OUTPUT_CLOSE_BRACKET = "]";

    private BuyResultView() {
        throw new AssertionError();
    }

    public static void printBuyingLottos(List<Lotto> buyingLottos) {
        System.out.println(String.format(OUTPUT_BUYING_LOTTOS, buyingLottos.size()));

        for (Lotto lotto : buyingLottos) {
            printLottos(lotto);
        }
    }

    private static void printLottos(Lotto lotto) {
        StringBuilder sb = new StringBuilder();
        sb.append(OUTPUT_OPEN_BRACKET);
        sb.append(lotto.get()
                .stream()
                .map(num -> String.valueOf(num))
                .collect(Collectors.joining(DELIMITER)));
        sb.append(OUTPUT_CLOSE_BRACKET);
        System.out.println(sb);
    }
}
