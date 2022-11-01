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
        LottoTicketInput lottoTicketInput;
        ManualLottoInput manualLottoInput;
        try{
            lottoTicketInput = inputView.getLottoTicket();
            manualLottoInput = inputView.getManualCountInput(lottoTicketInput);
        } catch (InputMismatchException e){
            System.out.println("input should be number");
            return;
        }
        Lottos lottos = new Lottos(makeRandomLottos(lottoTicketInput.getTicketCount() - manualLottoInput.getInputSize()));
        lottos.addAll(manualLottoInput.toLottos());
        resultView.printLottoCount(lottoTicketInput, manualLottoInput);
        resultView.printLottos(lottos);

        RewardStatistics rewardStatistics = lottos.match(inputView.getWinningNumbers());
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
