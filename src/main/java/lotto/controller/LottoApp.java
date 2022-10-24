package lotto.controller;

import lotto.service.*;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.input.TicketPriceInput;
import lotto.strategy.LottoWinningGenerateStrategy;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApp {

    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    public void start(){
        TicketPriceInput ticketPriceInput = inputView.getTicketPriceInput();
        Lottos lottos = new Lottos(ticketPriceInput.getTicketAmt());
        resultView.printLottos(lottos);

        String winningLottoNumbersInput = inputView.getWinningNumbers();
        LottoJudge lottoJudge = new LottoJudge();
        Lotto winningLotto = new Lotto(new LottoWinningGenerateStrategy(winningLottoNumbersInput));
        RewardCalculator rewardCalculator = lottoJudge.judge(lottos, winningLotto);
        resultView.printResult(rewardCalculator, rewardCalculator.getProfitRatio(lottos));
    }
}
