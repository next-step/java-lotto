package lotto.view;

import lotto.domain.Fee;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.Scanner;
import java.util.stream.Collectors;

public class ResultView {

    private static final String ANSWER_STATICS = "당첨 통계";
    private static final String LINE = "---------";
    private static final String NEW_LINE = System.lineSeparator();

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void showLottos(Lottos lottos) {
        printLotto(lottos);
    }

    private static void printLotto(Lottos lottos) {
        for (Lotto lotto : lottos.getValue()) {
            System.out.println(joinWithDelimiter(lotto));
        }
    }

    private static String joinWithDelimiter(Lotto lotto) {
        return lotto.getValue().stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ","[","]"));
    }

    public static void showStatistics(Lottos lottos, Lotto winningNumber, Fee fee) {
        StringBuilder sb = new StringBuilder();
        sb.append(ANSWER_STATICS)
                .append(NEW_LINE)
                .append(LINE)
                .append(NEW_LINE)
                .append("3개 일치 (5000원)- ")
                .append(lottos.match(winningNumber, 3))
                .append(NEW_LINE)
                .append("4개 일치 (50000원)- ")
                .append(lottos.match(winningNumber, 4))
                .append(NEW_LINE)
                .append("5개 일치 (1500000원)- ")
                .append(lottos.match(winningNumber, 5))
                .append(NEW_LINE)
                .append("6개 일치 (2000000000원)- ")
                .append(lottos.match(winningNumber, 6))
                .append(NEW_LINE)
                .append("총 수익률은 ")
                .append(lottos.calculateMargin(winningNumber, fee))
                .append("입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        System.out.println(sb.toString());
    }
}
