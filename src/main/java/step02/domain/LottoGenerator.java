package step02.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoGenerator {
    private static final int LOTTO_NUMBER_COUNT = 6;

    private final List<LottoNumber> lottoNumbers;

    private LottoGenerator(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoGenerator of(Integer from, Integer to) {
        return new LottoGenerator(generate(from, to));
    }

    private static List<LottoNumber> generate(Integer from, Integer to) {
        return Stream.iterate(from, n -> n + 1)
                .limit(to)
                .map(number -> LottoNumber.of(number))
                .collect(Collectors.toList());
    }

    public Lotto generate() {
        Collections.shuffle(lottoNumbers);

        List<LottoNumber> lotto = lottoNumbers.stream()
                .limit(LOTTO_NUMBER_COUNT)
                .collect(Collectors.toList());

        return Lotto.of(lotto);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoGenerator that = (LottoGenerator) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
