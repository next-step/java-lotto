package lotto.view;

import lotto.domain.EqualNumbers;
import lotto.service.BuyLotto;

public class LottoOutput {
    public void displayBuyLottoNumbers(BuyLotto buyLotto) {
        for (int i = 0; i < buyLotto.lottosCount(); i++) {
            System.out.println(buyLotto.getNumbers(i).toString());
        }
    }

    public void displayWinOfResult(EqualNumbers equalNumbers) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5,000원) - " + equalNumbers.getEqual3() + "개");
        System.out.println("4개 일치 (50,000원) - " + equalNumbers.getEqual4() + "개");
        System.out.println("5개 일치 (1,500,000원) - " + equalNumbers.getEqual5() + "개");
        System.out.println("5개 일치, 보너스 볼 일치(30,000,000원) - " + equalNumbers.getEqual5_bonus() + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + equalNumbers.getEqual6() + "개");
    }

    public void displayPriceEarningsRatio(EqualNumbers equalNumbers, BuyLotto buyLotto) {
        float priceEarninsRatio = (float) ((equalNumbers.getTotalWinAmt() - buyLotto.getBuyAmt()) / buyLotto.getBuyAmt()) * 100;

        System.out.println("총 수익률은 " + priceEarninsRatio + "% 입니다.");
    }
}
