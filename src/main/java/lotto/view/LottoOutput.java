package lotto.view;

import lotto.domain.TotalEqualNumbers;
import lotto.service.BuyLotto;

public class LottoOutput {
    public void displayBuyLottoNumbers(BuyLotto buyLotto) {
        buyLotto.getLottos().getLottos().stream()
                .forEach(numbers -> System.out.println(numbers.getNumbers()));
    }

    public void displayWinOfResult(TotalEqualNumbers totalEqualNumbers) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5,000원) - " + totalEqualNumbers.getEqualsNumberCount3() + "개");
        System.out.println("4개 일치 (50,000원) - " + totalEqualNumbers.getEqualsNumberCount4() + "개");
        System.out.println("5개 일치 (1,500,000원) - " + totalEqualNumbers.getEqualsNumberCount5() + "개");
        System.out.println("5개 일치, 보너스 볼 일치(30,000,000원) - " + totalEqualNumbers.getEqualsNumberCountBonus5() + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + totalEqualNumbers.getEqualsNumberCount6() + "개");
    }

    public void displayPriceEarningsRatio(TotalEqualNumbers totalEqualNumbers, BuyLotto buyLotto) {
        float priceEarninsRatio = ((totalEqualNumbers.getTotalWinAmout() - buyLotto.getbuyAmount()) / buyLotto.getbuyAmount()) * 100;

        System.out.println("총 수익률은 " + priceEarninsRatio + "% 입니다.");
    }
}
