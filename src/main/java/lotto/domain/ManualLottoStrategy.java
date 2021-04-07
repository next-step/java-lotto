/*
 * 로또 수동 생성 전략을 나타내는 클래스
* */
package lotto.domain;

import lotto.ui.InputView;

import java.util.ArrayList;

public class ManualLottoStrategy implements LottoStrategy{
    @Override
    public Lotto makeLotto() {
        ArrayList<Integer> numbers = InputView.inputNumbers();
        LottoNumbers lottoNumbers = LottoNumbers.of(numbers);
        return new Lotto(lottoNumbers);
    }
}
