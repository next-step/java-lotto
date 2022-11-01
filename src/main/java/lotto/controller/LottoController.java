package lotto.controller;

import lotto.domain.*;
import lotto.input.ManualLottoInput;
import lotto.input.LottoTicketInput;
import lotto.strategy.LottoGenerateStrategy;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.*;

public class LottoController {

    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    public void start() {
        LottoTicketInput lottoTicketInput = inputView.getLottoTicket();
        ManualLottoInput manualLottoInput = inputView.getManualCountInput(lottoTicketInput);
        List<Lotto> manualLottos = manualLottoInput.getLottos();
        Lottos lottos = new Lottos(makeRandomLottos(lottoTicketInput.getTicketCount() - manualLottos.size()));
        lottos.addAll(manualLottos);
        resultView.printLottoCount(lottoTicketInput, manualLottoInput);
        resultView.printLottos(lottos);

        WinningLotto winningLotto = inputView.getWinningNumbers();
        RewardStatistics rewardStatistics = lottos.match(winningLotto);
        resultView.printAllResult(rewardStatistics, rewardStatistics.getProfitRatio(lottos));
    }

    private List<Lotto> makeRandomLottos(int randomLottoSize) {
        List<Lotto> result = new ArrayList<>();
        for (int i = 0; i < randomLottoSize; i++) {
            result.add(new Lotto(getRandomLottoStrategy()));
        }
        return result;
    }

    private LottoGenerateStrategy getRandomLottoStrategy(){
        return () -> {
            Collections.shuffle(Lotto.LOTTO_NUMBERS);
            List<LottoNumber> lottoResult = Lotto.LOTTO_NUMBERS.subList(0, 6);
            return new TreeSet<>(lottoResult);
        };
    }
}
