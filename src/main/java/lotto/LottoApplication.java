package lotto;

import lotto.model.Lottery;
import lotto.model.Lotto;
import lotto.model.BuyLotto;
import lotto.view.LottoInput;
import lotto.view.LottoOutput;

import java.util.List;

import static lotto.model.LottoFactory.generateLotto;

public class LottoApplication {
    private final LottoInput lottoInput;
    private final LottoOutput lottoOutput;

    public LottoApplication(LottoInput lottoInput, LottoOutput lottoOutput) {
        this.lottoInput = lottoInput;
        this.lottoOutput = lottoOutput;
    }

    public void run() {
        BuyLotto buyLotto = new BuyLotto(lottoInput.getInput());
        lottoOutput.viewLottoCount(buyLotto);
        List<Lotto> lottos = generateLotto(buyLotto);
        lottoOutput.viewLottoDetail(lottos);
        List<Integer> winnerNumbers = lottoInput.getWinningNumber();
        Lottery lottery = new Lottery(winnerNumbers, lottos);
        lottoOutput.viewCorrectLottos(lottery);
        lottoOutput.viewTotalIncomeRatio(lottery, buyLotto);
    }

}
