package step3.domain;

import step3.domain.lotto.LottoNumber;
import java.util.ArrayList;
import java.util.List;

public class LottoNumbersFactory {

    public static List<LottoNumber> buildLottoNumbers(Integer... numbers) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            lottoNumbers.add(new LottoNumber(number));
        }
        return lottoNumbers;
    }
}
