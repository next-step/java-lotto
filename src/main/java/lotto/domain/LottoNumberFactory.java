package lotto.domain;

import java.util.HashMap;

public final class LottoNumberFactory {

    private static final HashMap<Integer, LottoNumber> lottoMap = new HashMap<>();


    public static LottoNumber getLottoNumber(int number) {
        LottoNumber lottoNumber = lottoMap.get(number);

        if (lottoNumber == null) {
            lottoNumber = new LottoNumber(number);
            lottoMap.put(number, lottoNumber);
        }

        return lottoNumber;
    }

    public static LottoNumber getLottoNumber(String number) {
        int parseNumber = Integer.parseInt(number);

        return LottoNumberFactory.getLottoNumber(parseNumber);
    }

}
