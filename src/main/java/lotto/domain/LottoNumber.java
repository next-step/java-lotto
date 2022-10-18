package lotto.domain;

import lotto.expressions.LottoNumberExpression;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class LottoNumber {
    protected static final List<LottoNumber> CACHE = new ArrayList<>();
    static {
        IntStream.rangeClosed(LottoNumberExpression.LOTTO_MIN_NUMBER, LottoNumberExpression.LOTTO_MAX_NUMBER)
                .forEach(number -> CACHE.add(new LottoNumber(number)));
    }

    private final int number;

    public LottoNumber(int number) {
        LottoNumberExpression.validateNumber(number);
        this.number = number;
    }

    public static LottoNumber of(int number) {
        LottoNumber lottoNumber = CACHE.get(number);
        if (Objects.isNull(lottoNumber)) {
            lottoNumber = new LottoNumber(number);
        }
        return lottoNumber;
    }

    int getNumber() {
        return number;
    }
}
