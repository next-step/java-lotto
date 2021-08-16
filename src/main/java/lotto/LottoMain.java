package lotto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class LottoMain {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LottoGuidView view = new LottoGuidView();
        int purchaseAmount = view.getPurchaseAmount(br);

        LottoPurchasingMachine lottoPurchasingMachine = new LottoPurchasingMachine();
        List<Lotto> lottoList = lottoPurchasingMachine.buyLotto(purchaseAmount);
        view.showLottoList(lottoList);

    }
}
