package lotto.domain;

import java.util.HashMap;

public final class LottoNumberFactory {

    private static final HashMap<Integer, LottoNumber> LOTTO_NUMBER_MAP = new HashMap<>();

    public static LottoNumber getLottoNumber(final int number) {
        LottoNumber lottoNumber = LOTTO_NUMBER_MAP.get(number);

        if (lottoNumber == null) {
            lottoNumber = new LottoNumber(number);
            LOTTO_NUMBER_MAP.put(number, lottoNumber);
        }

        return lottoNumber;
    }

}
