package lotto.fixture;

import lotto.model.Lotto;

import java.util.List;

import static lotto.fixture.LottoNumberFixture.createLottoNumbers;


public class LottoFixture {
    public static Lotto createLotto(int... numbers) {
        return new Lotto(createLottoNumbers(numbers));
    }

    public static Lotto createLotto(List<Integer> numbers) {
        return new Lotto(createLottoNumbers(numbers));
    }
}
