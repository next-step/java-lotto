package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoNumber {

    private final static int MIN_LOTTO_NUMBER = 1;
    private final static int MAX_LOTTO_NUMBER = 45;

    private final static List<LottoNumber> LOTTO_NUMBERS = new ArrayList<>();

    private final int lottoNumber;

    static {
        for (int lottoNumber = MIN_LOTTO_NUMBER; lottoNumber <= MAX_LOTTO_NUMBER; lottoNumber++) {
            LOTTO_NUMBERS.add(new LottoNumber(lottoNumber));
        }
    }

    private LottoNumber(int number) {
        this.lottoNumber = number;
    }

    public static LottoNumber lottoNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("로또 번호는 1~45사이의 숫자만 조회 가능합니다.");
        }
        return LOTTO_NUMBERS.get(number - 1);
    }

    public static List<LottoNumber> lottoNumbers() {
        return Collections.unmodifiableList(LOTTO_NUMBERS);
    }

    public int lottoNumber() {
        return lottoNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
