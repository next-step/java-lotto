package lotto.view;

import lotto.domain.*;
import lotto.tool.LottoMachine;

import java.util.List;

public class ConsoleMain {
    public static void main(String[] args) {

        LottoMoney lottoMoney = InputView.inputMoney();
        List<String[]> manualLottoNumbers = InputView.inputManualLottoNumbers();
        OutputView.printTicketCount(lottoMoney, manualLottoNumbers.size());

        List<LottoTicket> lottoTickets = LottoMachine.issueTickets(lottoMoney, manualLottoNumbers);
        OutputView.printTickets(lottoTickets);

        WinningLotto winningLotto = InputView.inputWinningNumbers();

        LottoMatcher lottoMatcher = new LottoMatcher(lottoTickets, winningLotto);
        OutputView.printRankResult(lottoMatcher);

        EarningRate earningRate = new EarningRate(lottoMatcher, lottoMoney);
        OutputView.printEarningRate(earningRate);
    }
}
