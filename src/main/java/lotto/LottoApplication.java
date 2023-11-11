package lotto;

import lotto.application.LottoGeneration;
import lotto.domain.Lottos;
import lotto.domain.NumberGeneration;
import lotto.domain.RandomNumberGeneration;

import static lotto.ui.InputView.inputPurchaseAmount;
import static lotto.ui.ResultView.*;

public class LottoApplication {
    public static void main(String[] args) {
        int purchaseAmount = inputPurchaseAmount();
        NumberGeneration numberGeneration = new RandomNumberGeneration();

        LottoGeneration lottoGeneration = new LottoGeneration();
        Lottos lottos = lottoGeneration.generateLottoNumbers(purchaseAmount, numberGeneration);

        printLottoCount(lottos.size());
        printLottoBundle(lottos.find());




    }
}
