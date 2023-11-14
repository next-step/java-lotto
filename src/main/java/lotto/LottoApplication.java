package lotto;

import lotto.application.LottoGeneration;
import lotto.application.LottoPlay;
import lotto.domain.Lottos;
import lotto.domain.NumberGeneration;
import lotto.domain.RandomNumberGeneration;

import java.util.List;

import static lotto.ui.InputView.*;
import static lotto.ui.ResultView.*;

public class LottoApplication {
    public static void main(String[] args) {
        int purchaseAmount = inputPurchaseAmount();
        int count = isMorThanStandard(purchaseAmount);

        NumberGeneration numberGeneration = new RandomNumberGeneration();

        LottoGeneration lottoGeneration = new LottoGeneration();
        Lottos lottos = lottoGeneration.generateLottoNumbers(count, numberGeneration);

        printLottoCount(lottos.size());
        printLottoBundle(lottos.find());

        List<Integer> winNumbers = inputWiningNumbers();

        LottoPlay lottoPlay = new LottoPlay(lottos, winNumbers);

        printMatchStats(lottoPlay.findMatchResult());
        printMatchResult(purchaseAmount, lottoPlay.sumMatch());








    }
}
