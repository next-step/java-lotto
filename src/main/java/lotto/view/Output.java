package lotto.view;

import lotto.domain.PurchasedLotto;
import lotto.dto.LottoResultDto;

import static lotto.util.ConstUtils.*;

public class Output {

    public void printPurchaseResult(PurchasedLotto purchasedLotto) {
        System.out.println(purchasedLotto.purchasedLottoSize() + "개를 구매했습니다.");
        System.out.println(purchasedLotto);
    }

    public void printWinningResult(LottoResultDto lottoResultDto) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");

        System.out.println("3개 일치 (" + WIN_THREE + "원)- " + lottoResultDto.getMatchThreeNumbers() + "개");
        System.out.println("4개 일치 (" + WIN_FOUR + "원)- " + lottoResultDto.getMatchFourNumbers() + "개");
        System.out.println("5개 일치 (" + WIN_FIVE + "원)- " + lottoResultDto.getMatchFiveNumbers() + "개");
        System.out.println("6개 일치 (" + WIN_SIX + "원)- " + lottoResultDto.getMatchSixNumbers() + "개");

        String earnOrLoss = (lottoResultDto.getEarnRate() > 1) ? "이익" : "손해";
        System.out.printf("총 수익률은 %.2f입니다. (%s)\n", lottoResultDto.getEarnRate(), earnOrLoss);
    }
}
