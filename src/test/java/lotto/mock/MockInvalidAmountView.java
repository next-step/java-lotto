package lotto.mock;

import lotto.domain.Lottos;
import lotto.domain.ManualLottoNumbers;
import lotto.domain.NumberOfManualLotto;
import lotto.dto.WinningStatistic;
import lotto.view.View;

import java.util.Set;

public class MockInvalidAmountView implements View {
    @Override
    public int getAmount() {
        return -1;
    }

    @Override
    public Set<Integer> getWinningNumbers() {
        return null;
    }

    @Override
    public int getBonusNumber() {
        return 0;
    }

    @Override
    public int getNumberOfManualLotto() {
        return 0;
    }

    @Override
    public ManualLottoNumbers getManualLottoNumbers(NumberOfManualLotto numberOfManualLotto) {
        return null;
    }

    @Override
    public void printInputError(Exception e) {

    }

    @Override
    public void printBoughtLottos(ManualLottoNumbers manualLottoNumbers, Lottos boughtLottos) {

    }

    @Override
    public void printWinningStatistic(WinningStatistic winningStatistic) {

    }
}
