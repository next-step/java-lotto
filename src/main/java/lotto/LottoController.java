package lotto;

import calculator.domain.NumberGeneration;
import calculator.domain.RandomNumberGeneration;
import lotto.domain.LottoRanks;
import lotto.domain.Lottos;

import java.util.List;

import static lotto.ui.InputView.*;
import static lotto.ui.ResultView.*;

public class LottoController {

    public static final NumberGeneration NUMBER_GENERATION = new RandomNumberGeneration();

    public static void main(String[] args) {
        int amount = inputPurchaseAmount();

        Lottos lottos = new Lottos(amount, NUMBER_GENERATION);
        printLottoCount(lottos.count());
        printLottoBundle(lottos.find());

        List<Integer> winNumbers = inputWiningNumbers();
        int bonus = inputBonusBall();

        LottoRanks lottoRanks = new LottoRanks(lottos, winNumbers, bonus);
        printMatchStats(lottoRanks.find());
        System.out.println(lottoRanks.find()
        );
        printMatchResult(amount, lottoRanks.findPrizeMoney());


    }
}
