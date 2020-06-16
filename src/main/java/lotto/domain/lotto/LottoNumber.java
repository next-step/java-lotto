package lotto.domain.lotto;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 45;
    private static final List<LottoNumber> LOTTO_NUMBERS =
            Collections.unmodifiableList(IntStream.rangeClosed(START_NUMBER, END_NUMBER)
                    .mapToObj(number -> new LottoNumber(number))
                    .collect(Collectors.toList()));

    private final int lottoNumber;

    private LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber create(int lottoNumber) {
        checkInRange(lottoNumber);
        return LOTTO_NUMBERS.get(lottoNumber - 1);
    }

    private static void checkInRange(int lottoNumber) {
        if(lottoNumber < START_NUMBER || lottoNumber > END_NUMBER){
            throw new IllegalArgumentException("입력 값이 유효하지 않습니다.");
        }
    }

    @Override
    public int compareTo(LottoNumber out) {
        return Integer.compare(this.lottoNumber, out.lottoNumber);
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoNumber)) return false;
        LottoNumber lottoNumber = (LottoNumber) o;
        return this.lottoNumber == lottoNumber.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
