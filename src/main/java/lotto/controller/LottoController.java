package lotto.controller;

import lotto.domain.WinningLotto;
import lotto.service.*;
import lotto.domain.Lottos;
import lotto.input.TicketPriceInput;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    public void start(){
        TicketPriceInput ticketPriceInput = inputView.getTicketPriceInput();
        Lottos lottos = new Lottos(ticketPriceInput.getTicketAmt());
        resultView.printLottos(lottos);

        WinningLotto winningLotto = inputView.getWinningNumbers();
        LottoJudge lottoJudge = new LottoJudge();
        RewardCalculator rewardCalculator = lottoJudge.judge(lottos, winningLotto);
        resultView.printAllResult(rewardCalculator, rewardCalculator.getProfitRatio(lottos));
    }
}
