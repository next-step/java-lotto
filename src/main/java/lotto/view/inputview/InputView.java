package lotto.view.inputview;

import java.util.List;
import java.util.Set;

public interface InputView {
    int getAmount();

    Set<Integer> getWinningNumbers();

    int getBonusNumber();

    int getNumberOfManualLotto();

    List<Set<Integer>> getManualLottoNumbers(int numberOfManualLotto);
}
