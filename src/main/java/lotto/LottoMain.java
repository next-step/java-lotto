package lotto;

import util.Number;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LottoMain {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LottoGuidView view = new LottoGuidView(br);
        int purchaseAmount = view.getPurchaseAmount();
        int manualNumberPurchase = view.getManualNumberPurchase();
        String[] enterManualNumberPurchase = view.enterManualNumberPurchase(manualNumberPurchase);
        LottoPurchasingMachine lottoPurchasingMachine = new LottoPurchasingMachine();

        List<Lotto> manualLotto = lottoPurchasingMachine.buyManualLotto(enterManualNumberPurchase);
        List<Lotto> automaticLotto = lottoPurchasingMachine.buyAutomaticLotto(purchaseAmount - (manualLotto.size() * LottoPurchasingMachine.AMOUNT));

        int manualLottoCount = manualLotto.size();
        int automaticLottoCount = automaticLotto.size();

        List<Lotto> lottoList = new ArrayList<>();
        lottoList.addAll(manualLotto);
        lottoList.addAll(automaticLotto);

        view.showLottoList(manualLottoCount, automaticLottoCount, lottoList);

        List<String> prevWinningLottoNumbers = view.getPrevWinningLottoNumbers();
        int bonusBallNumber = Integer.parseInt(view.enteredBonusBallNumber());
        List<Integer> result = lottoPurchasingMachine.checkLottoList(lottoList, Number.stringArrayToIntegerList(prevWinningLottoNumbers), bonusBallNumber);
        double yield = lottoPurchasingMachine.findYield(result, purchaseAmount);
        view.showNumericalStatement(result, yield);

    }
}
