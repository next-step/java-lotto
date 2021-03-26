package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public static final String PURCHASE_COUNT_MESSAGE = "%d개를 구매했습니다.\n";
    public static final String NEW_LINE = "\n";

    private ResultView() {

    }

    public static void printLottoPurchased(List<Lotto> lottoList) {
        System.out.printf(PURCHASE_COUNT_MESSAGE, lottoList.size());
        String lottoListMessage = lottoList.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining(NEW_LINE));
        System.out.println(lottoListMessage);
        System.out.println();
    }
}
