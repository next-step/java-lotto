package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {
    public static final List<Integer> LOTTO_NUMBER_SET = IntStream.rangeClosed(1, 45)
            .boxed()
            .collect(Collectors.toList());
    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validate(lottoNumber);

        this.lottoNumber = lottoNumber;
    }

    private static void validate(int lottoNumber) {
        if (!LOTTO_NUMBER_SET.contains(lottoNumber)) {
            throw new IllegalArgumentException("로또 번호의 범위는 1~45까지입니다.");
        }
    }

    public int getLottoNumber() {
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
