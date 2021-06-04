package study.lotto.domain;

import study.lotto.exception.WrongLottoNumberException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    public static final int LOTTONUMBER_FROM = 1;
    public static final int LOTTONUMBER_TO = 45;
    public static final Map<Integer, LottoNumber> LOTTO_NUMBER_MAP = new HashMap<>();

    private final int lottoNumber;

    static {
        for (int i = LOTTONUMBER_FROM; i <= LOTTONUMBER_TO ; i++) {
            LOTTO_NUMBER_MAP.put(i, new LottoNumber(i));
        }
    }


    private LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber of(int number) {
        LottoNumber lottoNumber = LOTTO_NUMBER_MAP.get(number);
        if (lottoNumber == null) {
            throw new WrongLottoNumberException();
        }
        return lottoNumber;
    }

    public static LottoNumber of(String stringNumber) {
        return of(Integer.parseInt(stringNumber));
    }


    public int value() {
        return lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof LottoNumber)) {
            return false;
        }
        LottoNumber l = (LottoNumber) obj;
        return lottoNumber == l.lottoNumber;
    }

    @Override
    public int compareTo(LottoNumber lottoNumber) {
        return this.lottoNumber - lottoNumber.value();
    }

}
