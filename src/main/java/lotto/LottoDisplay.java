package lotto;

import lotto.entity.LottoMoney;
import lotto.controller.LottoMachine;
import lotto.entity.Lottos;
import lotto.entity.PrizePolicy;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Map;

public class LottoDisplay {
    private static final InputView inputView = new InputView();
    private static final LottoMoney LOTTO_MONEY = new LottoMoney();
    private static final ResultView resultView = new ResultView();
    private static final LottoMachine lottoMachine = new LottoMachine();

    public static void main(String[] args) {
        int totalMoney = inputView.inputTotalAmount();

        int totalTicketCount = LOTTO_MONEY.makeLottoGamePapers(totalMoney);

        resultView.printTotalLottoTicketCount(totalTicketCount);

        Lottos totalLottoTickets = lottoMachine.makeTotalLottoTickets(totalTicketCount);
        resultView.printLottoTickets(totalLottoTickets);

        List<Integer> matchingCountResult = lottoMachine.checkMatchingNumber(inputView.inputWinningNumbers());
        Map<PrizePolicy, Integer> matchingResult = lottoMachine.winningResult(matchingCountResult);

        int totalPrizeMoney = resultView.printTotalResult(matchingResult);

        resultView.printRateOfReturn(lottoMachine.rateOfReturnResult(totalMoney, totalPrizeMoney));
    }
}
