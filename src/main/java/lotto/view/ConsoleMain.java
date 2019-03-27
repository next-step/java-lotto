package lotto.view;

import lotto.domain.*;
import lotto.tool.LottoMachine;

import java.util.List;

public class ConsoleMain {
    public static void main(String[] args) {

        LottoMoney lottoMoney = InputView.inputMoney();
        List<String[]> manualLottoNumbers = InputView.inputManualLottoNumbers();
        OutputView.printTicketCount(lottoMoney, manualLottoNumbers.size());

        LottoBundle lottoBundle = LottoMachine.issueTickets(lottoMoney, manualLottoNumbers);
        OutputView.printTickets(lottoBundle);

        WinningLotto winningLotto = InputView.inputWinningNumbers();

        LottoMatcher lottoMatcher = new LottoMatcher(lottoBundle, winningLotto);
        OutputView.printRankResult(lottoMatcher);

        EarningRate earningRate = new EarningRate(lottoMatcher, lottoMoney);
        OutputView.printEarningRate(earningRate);
    }
}
