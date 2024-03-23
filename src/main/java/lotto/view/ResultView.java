package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoSale;

import java.util.List;

public class ResultView {
    public static void printSaleResult(int result) {
        System.out.println(result + "개를 구매했습니다.");
    }
    public static void printSaleResultTest(LottoSale lottosaletest, int purchaseChance) {
        //outputPurchasedLottos(purchaseChance);
        printSaleResult(purchaseChance);
        outputPurchasedLottoDetail(lottosaletest, purchaseChance);
    }

    private static void outputPurchasedLottoDetail(LottoSale lottoSale, int chances) {
        List<Lotto> lottos = lottoSale.getLottos();

        for (Lotto lotto : lottos) {
            System.out.println(lotto.getLotto().toString());
        }
    }

}
