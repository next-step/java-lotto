package lotto.mock;

import lotto.domain.Lotto;
import lotto.dto.Lottos;
import lotto.dto.ManualLottoNumbers;
import lotto.dto.NumberOfManualLotto;
import lotto.dto.WinningStatistic;
import lotto.view.View;

import java.util.Set;

public class MockInvalidManualLottoView implements View {
    private static final int LOTTO_SIZE = 5;

    @Override
    public int getAmount() {
        return Lotto.PRICE_OF_ONE_LOTTO * LOTTO_SIZE;
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
        return LOTTO_SIZE + 1;
    }

    @Override
    public ManualLottoNumbers getManualLottoNumbers(NumberOfManualLotto numberOfManualLotto) {
        return null;
    }

    @Override
    public void printBoughtLottos(ManualLottoNumbers manualLottoNumbers, Lottos boughtLottos) {

    }

    @Override
    public void printWinningStatistic(WinningStatistic winningStatistic) {

    }

    @Override
    public void printInputError(Exception e) {

    }
}
