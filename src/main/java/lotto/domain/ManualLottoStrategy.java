package lotto.domain;

import lotto.ui.InputView;

import java.util.ArrayList;

public class ManualLottoStrategy implements LottoStrategy{
    @Override
    public LottoNumbers makeLotto() {
        ArrayList<Integer> numbers = InputView.inputNumbers();
        return LottoNumbers.of(numbers);
    }
}
