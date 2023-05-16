package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoFixture {
    public static Lotto lottoFixture(String manualInput) {
        return new Lotto(lottoNumbersFixture(manualInput));
    }

    public static WinLotto winLottoFixture(String input) {
        return new WinLotto(lottoNumbersFixture(input));
    }

    public static WinLotto winLottoWithBonusFixture(String input, LottoNo bonusNumber) {
        return new WinLotto(lottoNumbersFixture(input), bonusNumber);
    }

    public static LottoNumbers lottoNumbersFixture(String manualInput) {
        List<LottoNo> numbers = new ArrayList<>();
        String[] strNumbers = manualInput.split(", ");
        for (String strNumber : strNumbers) {
            numbers.add(LottoNo.of(Integer.parseInt(strNumber)));
        }
        return new LottoNumbers(numbers);
    }
}
