package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.io.PrintStream;
import java.util.stream.Collectors;

public class OutputView {
    public static final String LOTTO_NUMBER_SPLITTER = ",";
    private static final String LOTTO_PREFIX = "[";
    private static final String LOTTO_SUFFIX = "]";
    private static final String LOTTO_DELIMITER = LOTTO_SUFFIX + "\n" + LOTTO_PREFIX;
    private static final String LOTTO_NUM_MESSAGE = "개를 구매했습니다.\n";
    private static final PrintStream out = System.out;

    private OutputView() {
    }

    public static void showLottoNum(int lottoNum) {
        out.println(lottoNum + LOTTO_NUM_MESSAGE);
    }

    public static void showLottos(Lottos lottos) {
        out.println(getLottosString(lottos));
    }

    private static String getLottosString(Lottos lottos) {
        String lottosString = lottos.getLottoList().stream()
                .map(OutputView::getLottoString)
                .collect(Collectors.joining(LOTTO_DELIMITER));
        return LOTTO_PREFIX + lottosString + LOTTO_SUFFIX;
    }

    private static String getLottoString(Lotto lotto) {
        return lotto.getNumbers().getNumberList()
                .stream()
                .map(Object::toString)
                .collect(Collectors.joining(LOTTO_NUMBER_SPLITTER));
    }
}
