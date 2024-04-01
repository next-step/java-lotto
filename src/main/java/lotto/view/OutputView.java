package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.WinningStatic;
import lotto.domain.WinningType;

import java.util.List;

public class OutputView {
    public static void printBuyLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    public static void printWinningStatic(WinningStatic winningStatic) {
        System.out.println("[당첨 통계]");
        StringBuilder result = new StringBuilder();
        for (WinningType type : WinningType.values()) {
            Long winnerCount = winningStatic.countWinnersByWinningType(type);
            Long hitCount = type.getHitCount();
            Long revenue = type.getRevenue();

            result.append(hitCount + "개 일치 ")
                    .append(type.is2ndBonusWinner() ? "보너스볼 일치" : "")
                    .append("(" + revenue + "원) - ")
                    .append(winnerCount + "개\n");
        }
        System.out.println(result);
    }

    public static void printReturnRate(double returnRate) {
        String roundedReturnRate = String.format("%.2f", returnRate);
        System.out.println("총 수익율은 " + roundedReturnRate + " 입니다.");
        if (returnRate < 1) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }
}
