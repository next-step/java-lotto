package lotto.view.inputview;

import lotto.domain.ManualLottoNumbers;
import lotto.domain.NumberOfManualLotto;

import java.util.Set;

public interface InputView {
    int getAmount();

    Set<Integer> getWinningNumbers();

    int getBonusNumber();

    int getNumberOfManualLotto();

    ManualLottoNumbers getManualLottoNumbers(NumberOfManualLotto numberOfManualLotto);

    void printInputError(Exception e);
}
