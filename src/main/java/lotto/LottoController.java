package lotto;

import lotto.domain.LottoRanks;
import lotto.domain.Lottos;
import lotto.domain.NumberGeneration;
import lotto.domain.RandomNumberGeneration;

import java.util.List;

import static lotto.ui.InputView.*;
import static lotto.ui.ResultView.*;

public class LottoController {

    public static final NumberGeneration NUMBER_GENERATION = new RandomNumberGeneration();

    public static void main(String[] args) {

        int amount = inputPurchaseAmount();

        Lottos lottos = Lottos.extracted(amount, NUMBER_GENERATION);

        printLottoCount(lottos.count());
        printLottoBundle(lottos.find());

        List<Integer> winNumbers = inputWiningNumbers();
        int bonus = inputBonusBall();

        LottoRanks lottoRanks = new LottoRanks(lottos, winNumbers, bonus);

        printMatchStats(lottoRanks.find());
        printMatchResult(amount, lottoRanks.findPrizeMoney());

    }
}
