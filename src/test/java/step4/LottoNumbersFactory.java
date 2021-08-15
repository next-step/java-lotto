package step4;

import step4.domain.lotto.LottoNumber;
import java.util.ArrayList;
import java.util.List;

public class LottoNumbersFactory {

    public static List<LottoNumber> buildLottoNumbers(Integer... numbers) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            lottoNumbers.add(LottoNumber.of(number));
        }
        return lottoNumbers;
    }
}
