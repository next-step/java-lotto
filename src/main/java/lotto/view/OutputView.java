package lotto.view;

import java.io.PrintStream;

public class OutputView {
    private static final String LOTTO_NUM_MESSAGE = "개를 구매했습니다.\n";
    private static final PrintStream out = System.out;

    private OutputView() {
    }

    public static void showLottoNum(int lottoNum) {
        out.println(lottoNum + LOTTO_NUM_MESSAGE);
    }
}
