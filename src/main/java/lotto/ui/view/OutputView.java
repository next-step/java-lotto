package lotto.ui.view;

import lotto.domain.*;

import java.util.List;

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
        statistics.getGrades()
                .forEach(OutputView::showGrade);
        System.out.printf("총 수익률은 %.2f입니다.\n", statistics.yield());
    }

    private static void showGrade(Grade grade, Long count) {
        System.out.printf("%s개 일치 (%s원)- %s개\n", grade.getMatchCount(), grade.getReward(), count);
    }
}
