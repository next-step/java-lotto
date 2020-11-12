package lotto.mock;

import lotto.domain.Lotto;
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
    public void printBoughtLottos(int numberOfManualLotto, List<Lotto> boughtLottos) {

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
    public List<Set<Integer>> getManualLottoNumbers(int numberOfManualLotto) {
        return null;
    }
}
