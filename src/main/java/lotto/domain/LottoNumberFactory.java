package lotto.domain;

import java.util.HashMap;
import lotto.domain.exception.BallException;

public final class LottoNumberFactory {

    private static final HashMap<Integer, LottoNumber> lottoMap = new HashMap<>();

    public static LottoNumber getLottoNumber(int number) {
        validation(number);
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

    private static void validation(int lottoNumber) {
        if (lottoNumber < LottoNumber.MIN_NUMBER) {
            throw new BallException("로또 번호는 1이상의 값을 가져야 합니다.");
        }
        if (lottoNumber > LottoNumber.MAX_NUMBER) {
            throw new BallException("로또 번호는 45이하의 값을 가져야 합니다.");
        }
    }

}
