package lotto.view;

import lotto.domain.EqualNumbersMoney;
import lotto.domain.BuyLotto;

public class LottoOutput {
    public void displayBuyLottoNumbers(BuyLotto buyLotto) {
        buyLotto.getLottos().getLottos()
                .forEach(numbers -> System.out.println(numbers.getNumbers()));
    }

    public void displayCount(BuyLotto buyLotto) {
        System.out.println("수동으로 " + buyLotto.getPassiveCount().getCount() + "장, "
                + "자동으로 " + buyLotto.getAutoCount().getCount() + "개를 구매했습니다.");
    }

    public void displayWinOfResult() {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println(EqualNumbersMoney.EQUALS_3);
        System.out.println(EqualNumbersMoney.EQUALS_4);
        System.out.println(EqualNumbersMoney.EQUALS_5);
        System.out.println(EqualNumbersMoney.EQUALS_5_BONUS);
        System.out.println(EqualNumbersMoney.EQUALS_6);
    }

    public void displayPriceEarningsRatio(BuyLotto buyLotto) {
        float priceEarninsRatio = ((EqualNumbersMoney.EQUALS.getWinAmountTotal() - buyLotto.getbuyAmount()) / buyLotto.getbuyAmount()) * 100;

        System.out.println("총 수익률은 " + priceEarninsRatio + "% 입니다.");
    }
}
