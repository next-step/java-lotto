package lotto.view;

import lotto.domain.*;
import lotto.dto.WinningLottoDTO;

import java.math.BigDecimal;

public class ResultView {
    private ResultView() {

    }

    public static void purchaseCount(Lottos lottos, PositiveNumber manulCount) {
        System.out.println("수동으로 " + manulCount + "장, 자동으로 " + (lottos.size() - manulCount.getPositiveNumber()) + "장을 구매했습니다.");
    }

    public static void noGame() {
        System.out.println("구입한 로또가 없습니다.");
    }

    public static void lottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.toString());
        }
        System.out.println();
    }

    public static void winningStaticsMessage() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    public static void winningStatics(WinningLottoDTO winningLottoDTO, Lottos lottos, Winning winning) {
        int correctCount = winning.correctCount();
        boolean bonusCorrect = winning.bonusCorrectCount();
        Amount winningAmount = winning.winningAmount();

        if (bonusCorrect) {
            System.out.println(correctCount + "개 일치, 보너스 볼 일치(" + winningAmount.amount() + "원) - " + lottos.winningCorrectCount(winningLottoDTO, winning) + "개");
            return;
        }
        System.out.println(correctCount + "개 일치 (" + winningAmount.amount() + "원) - " + lottos.winningCorrectCount(winningLottoDTO, winning) + "개");
    }

    public static void rateOfReturn(BigDecimal rate) {
        System.out.println("총 수익률은 " + rate + "입니다.");
    }
}
