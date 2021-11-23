package lotto.controller.view;

import lotto.domain.*;

import java.util.stream.Collectors;

import static java.lang.String.format;

public class OutputView {

    private static final StringBuilder stringBuilder = new StringBuilder();
    private static final int BREAK_EVEN_RATIO = 1;
    private static final int STRING_BUFFER_CLEAR_LENGTH = 0;
    private static final String DELIMITER = ", ";

    private OutputView() {
    }

    public static void showTicket(LottoTicket lottoTicket) {
        print(format("\n수동으로 %d개, 자동으로 %d개를 구매했습니다.", lottoTicket.manualLottoLinesCount(), lottoTicket.autoLottoLinesCount()));
        lottoTicket.allLottoLines()
                .forEach(OutputView::showLine);
        newLine();
    }

    private static void showLine(LottoNumbers lottoLine) {
        stringBuilder.append("[")
                .append(toSeparatedNumbers(lottoLine))
                .append("]");
        flush();
    }

    private static String toSeparatedNumbers(LottoNumbers lottoLine) {
        return lottoLine.lottoNumbers().stream()
                .map(LottoNumber::getNumber)
                .map(String::valueOf)
                .collect(Collectors.joining(DELIMITER));
    }

    public static void showStatistics(Statistics statistics) {
        print("\n당첨통계\n--------");

        statistics.getReverseOrderedGrades()
                .forEach(OutputView::showGrade);

        double yield = statistics.yield();
        print(format("총 수익률은 %.2f입니다.", yield));
        printBreakEvenRatioMessage(yield);
    }

    private static void showGrade(Grade grade, Long count) {
        if (grade == Grade.BONUS) {
            print(format("%d개 일치, 보너스볼 일치(%d원)- %d개", grade.getMatchCount(), grade.getReward(), count));
            return;
        }
        print(format("%d개 일치 (%d원)- %d개", grade.getMatchCount(), grade.getReward(), count));
    }

    private static void printBreakEvenRatioMessage(double yield) {
        if (yield < BREAK_EVEN_RATIO) {
            print(format("기준이 %d이기 때문에 결과적으로 손해라는 의미임.", BREAK_EVEN_RATIO));
        }
    }

    private static void flush() {
        System.out.println(stringBuilder);
        clearStringBuffer();
    }

    private static void clearStringBuffer() {
        stringBuilder.setLength(STRING_BUFFER_CLEAR_LENGTH);
    }

    private static void newLine() {
        System.out.println();
    }

    private static void print(String string) {
        System.out.println(string);
    }
}
