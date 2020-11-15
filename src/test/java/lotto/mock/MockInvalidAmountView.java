package lotto.mock;

import lotto.domain.Lotto;
import lotto.dto.ManualLottoNumbers;
import lotto.dto.NumberOfManualLotto;
import lotto.dto.WinningStatistic;
import lotto.view.View;

import java.util.List;
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
    public void printWinningStatistic(WinningStatistic winningStatistic) {

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
    public void printBoughtLottos(ManualLottoNumbers manualLottoNumbers, List<Lotto> boughtLottos) {

    }
}
