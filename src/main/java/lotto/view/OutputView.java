package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.WinningType;

import java.util.List;
import java.util.Map;

public class OutputView {
    public static void printBuyLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    public static void printWinningStatic(Map<WinningType, Long> winningStatic) {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<WinningType, Long> entry : winningStatic.entrySet()) {
            Long hitCount = entry.getKey().getHitCount();
            boolean matchBonus = entry.getKey().isMatchBonus();
            Long winnerNumber = entry.getValue();

            Long revenue = WinningType.valueOf(hitCount, matchBonus).getRevenue();
            result.append(hitCount + "개 일치 ")
                    .append(entry.getKey().is2ndBonusWinner() ? "보너스볼 일치" : "")
                    .append("(" + revenue + "원) - ")
                    .append(winnerNumber + "개\n");
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
