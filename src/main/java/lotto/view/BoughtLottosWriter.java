package lotto.view;

import java.util.stream.Collectors;
import lotto.domain.BoughtLottos;
import lotto.domain.Lotto;

public class BoughtLottosWriter {

    private static final String DELIMITER = ", ";
    private static final String NEW_LINE = "\n";
    private static final String EMPTY = "";

    public void printBoughtLottos(
            final BoughtLottos manualBoughtLottos,
            final BoughtLottos autoBoughtLottos
    ) {
        final String result = "수동으로 "
                + manualBoughtLottos.getCount()
                + "장, 자동으로 "
                + autoBoughtLottos.getCount()
                + "개를 구매했습니다."
                + NEW_LINE
                + formatLottos(manualBoughtLottos)
                + NEW_LINE
                + formatLottos(autoBoughtLottos);
        System.out.println(result);
    }

    private static String formatLottos(final BoughtLottos boughtLottos) {
        if (boughtLottos.isEmpty()) {
            return EMPTY;
        }
        return boughtLottos.getLottos()
                .stream()
                .map(BoughtLottosWriter::formatBalls)
                .collect(Collectors.joining(NEW_LINE));
    }

    private static String formatBalls(final Lotto lotto) {
        String result = "[";
        result += lotto.getBallValues()
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(DELIMITER));
        return result + "]";
    }
}
