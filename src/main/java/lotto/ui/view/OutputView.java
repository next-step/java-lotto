package lotto.ui.view;

import lotto.domain.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class OutputView {

    private static final StringBuilder stringBuilder = new StringBuilder();

    private OutputView() {
    }

    public static void showTicket(LottoTicket lottoTicket) {
        List<LottoNumbers> lottoLines = lottoTicket.getLottoLines();
        for (LottoNumbers lottoLine : lottoLines) {
            showLine(lottoLine);
        }
        System.out.println();
    }

    private static void showLine(LottoNumbers lottoLine) {
        List<LottoNumber> lottoNumbers = lottoLine.lottoNumbers();
        stringBuilder.append("[" );
        for (LottoNumber lottoNumber : lottoNumbers) {
            stringBuilder.append(lottoNumber.getNumber())
                    .append(", ");
        }
        stringBuilder.setLength(stringBuilder.length() - 2);
        stringBuilder.append("]");
        System.out.println(stringBuilder);
        stringBuilder.setLength(0);
    }

    public static void showStatistics(Statistics statistics) {
        System.out.println("당첨통계");
        System.out.println("--------");

        Map<Grade, Long> grades = getReverseOrderedGrades(statistics);
        grades.forEach(OutputView::showGrade);

        double yield = statistics.yield();
        System.out.printf("총 수익률은 %.2f입니다.", yield);
        if (yield < 1) {
            System.out.print("기준이 1이기 때문에 결과적으로 손해라는 의미임.");
        }
        System.out.println();
    }

    private static Map<Grade, Long> getReverseOrderedGrades(Statistics statistics) {
        Map<Grade, Long> grades = new TreeMap<>(Collections.reverseOrder());
        grades.putAll(statistics.getGrades());
        return grades;
    }

    private static void showGrade(Grade grade, Long count) {
        if (grade == Grade.BONUS) {
            System.out.printf("%s개 일치, 보너스볼 일치(%s원)- %s개\n", grade.getMatchCount(), grade.getReward(), count);
            return;
        }
        System.out.printf("%s개 일치 (%s원)- %s개\n", grade.getMatchCount(), grade.getReward(), count);
    }
}
