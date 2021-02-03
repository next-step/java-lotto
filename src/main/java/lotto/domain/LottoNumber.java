package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    // 원시값 포장
    //원시값(및 래핑 클래스) 포장이란 원시 타입의 값을 그대로 사용하는 것이 아닌 원시값만을 인스턴스 필드로 가지는 클래스를 사용하는 것
    private static final int LOWER_BOUND_LOTTO = 1;
    private static final int UPPER_BOUND_LOTTO = 46;
    private final int lottoNumber;

    public LottoNumber(final int lottoNumber) {
        checkIsValid(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    public int getLottoNumber() {
        return this.lottoNumber;
    }

    private void checkIsValid(int lottoNumber) {
        if(lottoNumber < LOWER_BOUND_LOTTO || lottoNumber > UPPER_BOUND_LOTTO) {
            throw new IllegalArgumentException("로또 숫자의 유효 범위가 아닙니다.");
        }
    }

    @Override
    public int compareTo(LottoNumber lottoObject) {
        if(this.lottoNumber > lottoObject.getLottoNumber()) {
            return 1; // x에 대해서는 오름차순
        }
        else if(this.lottoNumber == lottoObject.getLottoNumber()) {
            if(this.lottoNumber < lottoObject.getLottoNumber()) { // y에 대해서는 내림차순
                return 1;
            }
        }
        return -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    public static LottoNumber of (final int number) {
        return new LottoNumber(number);
    }
}
