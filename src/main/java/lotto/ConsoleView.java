package lotto;

import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class ConsoleView {

    private final InputView inputView;
    private final ResultView resultView;

    public ConsoleView() {
        this.inputView = new InputView();
        this.resultView = new ResultView();
    }

    public int getPayment() {
        return inputView.inputPayment();
    }

    public int getManualLottoCount() {
        return inputView.inputManualLottoCount();
    }

    public List<List<Integer>> getManualLottoNumbers(int manualLottoCount) {
        return inputView.inputManualLottoNumbers(manualLottoCount);
    }

    public void printTickets(int manualLottoCount, int autoLottoCount) {
        resultView.printTickets(manualLottoCount, autoLottoCount);
    }

    public void printLottoTickets(List<LottoTicket> lottoTickets) {
        resultView.printLottoTickets(lottoTickets);
    }

    public List<Integer> getWinningNumbers() {
        return inputView.inputWinningNumbers();
    }

    public int getBonusNumber() {
        return inputView.inputBonusNumber();
    }

    public void printLottoResult(LottoResult lottoResult) {
        resultView.printLottoResult(lottoResult);
    }
}
