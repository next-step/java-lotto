package lottoauto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoStrategy implements LottoGenerateStrategy{
    @Override
    public LottoNumbers generateLottoNumbers() {
        return new LottoNumbers(shuffle());
    }

    private List<LottoNumber> shuffle() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();

        for (int i = LottoNumber.LOTTO_NUMBER_START; i <= LottoNumber.LOTTO_NUMBER_END; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }

        Collections.shuffle(lottoNumbers);

        return lottoNumbers.subList(LottoNumbers.ZERO, LottoNumbers.LOTTO_NUMBERS_SIZE);
    }
}
