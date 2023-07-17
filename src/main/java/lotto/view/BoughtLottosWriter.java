package lotto.view;

import java.util.stream.Collectors;
import lotto.domain.BoughtLottos;
import lotto.domain.LottoNumbers;

public class BoughtLottosWriter {

    private static final String DELIMITER = ", ";
    private static final String NEW_LINE = "\n";
    private static final String EMPTY = "";

    public void printBoughtLottos(
            final BoughtLottos manualBoughtLottos,
            final BoughtLottos autoBoughtLottos
    ) {
        final String result = "수동으로 "
                + manualBoughtLottos.getCount().getValue()
                + "장, 자동으로 "
                + autoBoughtLottos.getCount().getValue()
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
        return boughtLottos.getLottosNumbers()
                .stream()
                .map(BoughtLottosWriter::formatBalls)
                .collect(Collectors.joining(NEW_LINE));
    }

    private static String formatBalls(final LottoNumbers lottoNumbers) {
        String result = "[";
        result += lottoNumbers.getNumbers()
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(DELIMITER));
        return result + "]";
    }
}
