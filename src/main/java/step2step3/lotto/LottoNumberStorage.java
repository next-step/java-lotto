package step2step3.lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoNumberStorage {
    private final Map<Integer, LottoNumber> lottoNumbers = new HashMap<>();

    public LottoNumber lottoNumber(int number) {
        if (lottoNumbers.containsKey(number)) {
            return lottoNumbers.get(number);
        }

        LottoNumber lottoNumber = new LottoNumber(number);
        lottoNumbers.put(number, new LottoNumber(number));
        return lottoNumber;
    }
}
