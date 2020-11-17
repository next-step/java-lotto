package step02.domain;

import java.util.Arrays;
import java.util.stream.Stream;

public class LottoNumbers {
    private final Integer[] lottoNumbers;

    private LottoNumbers(Integer[] lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoNumbers of(int from, int to) {
        return new LottoNumbers(generate(from, to));
    }

    private static Integer[] generate(Integer from, Integer to) {
        return Stream.iterate(from, n -> n + 1)
                .limit(to).toArray(Integer[]::new);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Arrays.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(lottoNumbers);
    }
}
