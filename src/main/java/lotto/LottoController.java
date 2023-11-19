package lotto;

import lotto.domain.*;

import java.util.List;

import static lotto.ui.InputView.*;
import static lotto.ui.ResultView.*;

public class LottoController {

    public static final NumberGeneration NUMBER_GENERATION = new RandomNumberGeneration();

    public static void main(String[] args) {

        int amount = inputPurchaseAmount();
        int count = countByAmount(amount);
        int manual = inputManualCount();
        List<List<Integer>> manualList = inputManualList(manual);

        Lottos lottos = Lottos.generate(manualList, NUMBER_GENERATION,count);

        printLottoCount(count, manual);
        printLottoBundle(lottos.find());

        Lotto winNumbers = new Lotto(inputWiningNumbers());
        LottoNumber bonus = LottoNumber.valueOf(inputBonusBall());

        LottoRanks lottoRanks = new LottoRanks(lottos, winNumbers, bonus);

        printMatchStats(lottoRanks.find());
        printMatchResult(amount, lottoRanks.findPrizeMoney());

    }
}
