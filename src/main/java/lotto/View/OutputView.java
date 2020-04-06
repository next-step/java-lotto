package lotto.View;


import lotto.Domain.LottoGrade;
import lotto.Domain.LottoResult;
import lotto.Domain.Lottos;

import java.util.Map;

public class OutputView {
    private static final String INFORMATION_BUY_MANUAL = "수동으로 ";
    private static final String INFORMATION_BUY_AUTO = "장, 자동으로 ";
    private static final String INFORMATION_BUY_COUNT = "개를 구매했습니다.";
    private static final String INFORMATION_RESULT = "당첨 통계";

    private OutputView() {
    }

    public static OutputView init() {
        return new OutputView();
    }

    public void userInstructionCount(int manualCount, int autoCount) {
        System.out.println(INFORMATION_BUY_MANUAL + manualCount + INFORMATION_BUY_AUTO + autoCount + INFORMATION_BUY_COUNT);
    }

    public void boughtLottoList(Lottos lottos) {
        lottos.toList().stream().forEach(lotto -> {
            System.out.println(lotto.toString());
        });
    }

    public void LottoResult(LottoResult lottoResult) {
        System.out.println(INFORMATION_RESULT);
        System.out.println("---------");
        Map<LottoGrade, Integer> winList = lottoResult.winLottoGradeAndPrize();

        winList.entrySet()
                .stream()
                .filter(entry -> entry.getKey() != LottoGrade.MISS)
                .forEach(entry -> {
                    winLottoGradeAndPrizePrint(entry.getKey(), entry.getValue());
                });

        double revenueRate = lottoResult.revenueRate();

        System.out.println("총 수익률은 " +trimDecimalZeroResult(revenueRate) + "입니다.");
    }

    private void winLottoGradeAndPrizePrint(LottoGrade key, Integer value) {
        if(key.getMatchCount() == 5 && key.getMatchBonus()) {
            System.out.println(key.getMatchCount() + "개 일치, 보너스 볼 일치(" + key.getPrize() + "원) - " + value + "개");
            return;
        }
        System.out.println(key.getMatchCount() + "개 일치 (" + key.getPrize() + "원) - " + value + "개");
    }

    private String trimDecimalZeroResult(double result) {
        if ((int) result == result) {
            return String.valueOf((int) result);
        }
        return String.valueOf(result);
    }
}