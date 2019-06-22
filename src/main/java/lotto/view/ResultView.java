package lotto.view;

import lotto.Lottos;

import java.io.PrintStream;

public class ResultView {

    private static final PrintStream printStream = System.out;

    private static final String PURCHASED_LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";

    public static void printPurchasedLottoCount(int lottoCount) {

        printStream.println(lottoCount + PURCHASED_LOTTO_COUNT_MESSAGE);
    }

    public static void printLottosNumber(Lottos lottos) {

        printStream.print(lottos.toString());
    }
}
