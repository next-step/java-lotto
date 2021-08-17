package lotto;

import util.Number;

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

        String[] prevWinningLottoNumbers = view.getPrevWinningLottoNumbers(br);
        Integer[] result = lottoPurchasingMachine.checkLottoList(lottoList, Number.stringArrayToInteger(prevWinningLottoNumbers));
        double yield = lottoPurchasingMachine.getYield(result, purchaseAmount);
        view.showNumericalStatement(result, yield);

    }
}
