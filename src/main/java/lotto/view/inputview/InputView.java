package lotto.view.inputview;

import lotto.dto.ManualLottoNumbers;

import java.util.Set;

public interface InputView {
    int getAmount();

    Set<Integer> getWinningNumbers();

    int getBonusNumber();

    int getNumberOfManualLotto();

    ManualLottoNumbers getManualLottoNumbers(int numberOfManualLotto);

    void printInputError(Exception e);
}
