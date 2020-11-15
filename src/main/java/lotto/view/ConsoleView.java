package lotto.view;

import lotto.domain.Lotto;
import lotto.dto.ManualLottoNumbers;
import lotto.dto.NumberOfManualLotto;
import lotto.dto.WinningStatistic;
import lotto.view.inputview.InputView;
import lotto.view.resultview.ResultView;

import java.util.List;
import java.util.Set;

public class ConsoleView implements View {
    private final InputView inputView;
    private final ResultView resultView;

    public ConsoleView(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    @Override
    public int getAmount() {
        return inputView.getAmount();
    }

    @Override
    public Set<Integer> getWinningNumbers() {
        return inputView.getWinningNumbers();
    }

    @Override
    public void printBoughtLottos(ManualLottoNumbers manualLottoNumbers, List<Lotto> boughtLottos) {
        resultView.printBoughtLottos(manualLottoNumbers, boughtLottos);
    }

    @Override
    public void printWinningStatistic(WinningStatistic winningStatistic) {
        resultView.printWinningStatistic(winningStatistic);
    }

    @Override
    public int getBonusNumber() {
        return inputView.getBonusNumber();
    }

    @Override
    public int getNumberOfManualLotto() {
        return inputView.getNumberOfManualLotto();
    }

    @Override
    public ManualLottoNumbers getManualLottoNumbers(NumberOfManualLotto numberOfManualLotto) {
        return inputView.getManualLottoNumbers(numberOfManualLotto);
    }

    @Override
    public void printInputError(Exception e) {
        inputView.printInputError(e);
    }
}
