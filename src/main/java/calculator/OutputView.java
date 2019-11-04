package calculator;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {
    private static final String OUTPUT_MESSAGE_FORMAT = "결과는 : %d 입니다.";

    public static void printResult(int result) {
        System.out.println(String.format(OUTPUT_MESSAGE_FORMAT, result));
    }

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }
}
