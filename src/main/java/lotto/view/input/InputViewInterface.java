package lotto.view.input;

import lotto.domain.LottoNumber;

import java.util.List;
import java.util.function.Predicate;

public interface InputViewInterface {
    int getNumberInput();

    int[] getNumberListInput();

    int getValidatedNumberInput(Predicate<Integer> validator, String errorMessage);

    List<List<LottoNumber>> getManualLottoNumbers(int count);
}
