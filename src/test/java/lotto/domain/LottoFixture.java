package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoFixture {
    public static Lotto lottoFixture(List<Integer> numbers) {
        return new Lotto(lottoNumbersFixture(numbers));
    }

    public static WinLotto winLottoFixture(List<Integer> numbers) {
        return new WinLotto(lottoNumbersFixture(numbers));
    }

    public static WinLotto winLottoWithBonusFixture(List<Integer> numbers, LottoNo bonusNumber) {
        return new WinLotto(lottoNumbersFixture(numbers), bonusNumber);
    }

    public static LottoNumbers lottoNumbersFixture(List<Integer> numbers) {
        List<LottoNo> LottoNos = new ArrayList<>();
        for (int number : numbers) {
            LottoNos.add(LottoNo.of(number));
        }
        return new LottoNumbers(LottoNos);
    }
}
