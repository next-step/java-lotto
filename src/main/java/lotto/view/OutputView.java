package lotto.view;

import lotto.domain.Lotto;

import java.io.PrintStream;
import java.util.stream.Collectors;

public class OutputView {
    public static final String LOTTO_NUMBER_SPLITTER = ",";
    private static final String LOTTO_NUM_MESSAGE = "개를 구매했습니다.\n";
    private static final PrintStream out = System.out;

    private OutputView() {
    }

    public static void showLottoNum(int lottoNum) {
        out.println(lottoNum + LOTTO_NUM_MESSAGE);
    }
}
