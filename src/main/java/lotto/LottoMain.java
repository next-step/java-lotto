package lotto;

import util.Number;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class LottoMain {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LottoGuidView view = new LottoGuidView(br);
        int purchaseAmount = view.getPurchaseAmount();

        LottoPurchasingMachine lottoPurchasingMachine = new LottoPurchasingMachine();
        List<Lotto> lottoList = lottoPurchasingMachine.buyLotto(purchaseAmount);
        view.showLottoList(lottoList);

        List<String> prevWinningLottoNumbers = view.getPrevWinningLottoNumbers();
        prevWinningLottoNumbers.add(view.enteredBonusBallNumber());
        List<Integer> result = lottoPurchasingMachine.checkLottoList(lottoList, Number.stringArrayToIntegerList(prevWinningLottoNumbers));
        double yield = lottoPurchasingMachine.findYield(result, purchaseAmount);
        view.showNumericalStatement(result, yield);

    }
}
