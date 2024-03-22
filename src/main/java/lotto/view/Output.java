package lotto.view;

import lotto.data.LottoWinInfo;
import lotto.domain.PurchasedLotto;
import lotto.dto.LottoResultDto;

public class Output {

    public void printPurchaseResult(PurchasedLotto purchasedLotto) {
        System.out.println(purchasedLotto.purchasedCount() + "개를 구매했습니다.");
        purchasedLotto.getPurchasedLottoList()
                        .forEach(System.out::println);
        System.out.println();
    }

    public void printWinningResult(LottoResultDto lottoResultDto) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");

        System.out.println("3개 일치 (" + LottoWinInfo.WIN_FOURTH.getWinningPrice() + "원)- " + lottoResultDto.getMatchThreeNumbers() + "개");
        System.out.println("4개 일치 (" + LottoWinInfo.WIN_THIRD.getWinningPrice() + "원)- " + lottoResultDto.getMatchFourNumbers() + "개");
        System.out.println("5개 일치 (" + LottoWinInfo.WIN_SECOND.getWinningPrice() + "원)- " + lottoResultDto.getMatchFiveNumbers() + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (" + LottoWinInfo.WIN_FIRST_WITH_BONUS.getWinningPrice() + "원)- " + lottoResultDto.getMatchSixNumbersIncludeBonus() + "개");
        System.out.println("6개 일치 (" + LottoWinInfo.WIN_FIRST.getWinningPrice() + "원)- " + lottoResultDto.getMatchSixNumbers() + "개");

        String earnOrLoss = (lottoResultDto.getEarnRate() > 1) ? "이익" : "손해";
        System.out.printf("총 수익률은 %.2f입니다. (%s)\n", lottoResultDto.getEarnRate(), earnOrLoss);
    }
}
