package lotto.view;

import java.text.MessageFormat;
import java.util.List;
import lotto.domain.grade.Grade;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.PurchaseAmount;
import lotto.domain.winning.WinningStatistic;

public class Output {

    private Output() {
    }

    public static void printAutoLotto(List<Lotto> autoLotto) {
        autoLotto.stream().forEach(System.out::println);
    }

    public static void printPurchaseCount(PurchaseAmount purchaseAmount) {
        System.out.println(
            MessageFormat.format("{0}개를 구매했습니다.", purchaseAmount.getPurchaseAmount() / 1000));
    }

    public static void printLottoResult(WinningStatistic winningStatistic) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        printGradeResult(Grade.FOUR_GRADE, winningStatistic);
        printGradeResult(Grade.THIRD_GRADE, winningStatistic);
        printGradeResult(Grade.SECOND_GRADE, winningStatistic);
        printGradeResult(Grade.FIRST_GRADE, winningStatistic);
        System.out.println(
            MessageFormat.format("총 수익률은 {0}입니다.", winningStatistic.calculateProfitRate()));
    }

    private static void printGradeResult(Grade grade, WinningStatistic winningStatistic) {
        System.out.println(
            MessageFormat.format("{0}개 일치 ({1}원)- {2}",
                grade.getCorrectingCount(),
                grade.getPrizeMoney(),
                winningStatistic.getGradeCount(grade)));
    }
}
