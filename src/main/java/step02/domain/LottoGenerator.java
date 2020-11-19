package step02.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoGenerator {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private final Integer startNumber;
    private final Integer endNumber;

    private final List<LottoNumber> lottoNumbers;

    private LottoGenerator(List<LottoNumber> lottoNumbers, Integer startNumber, Integer endNumber) {
        this.lottoNumbers = lottoNumbers;
        this.startNumber = startNumber;
        this.endNumber = endNumber;
    }

    public static LottoGenerator of(Integer startNumber, Integer endNumber) {
        return new LottoGenerator(generate(startNumber, endNumber), startNumber, endNumber);
    }

    private static List<LottoNumber> generate(Integer startNumber, Integer endNumber) {

        return Stream.iterate(startNumber, n -> n + 1)
                .limit(endNumber)
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

    public boolean isValidNumberRange(Integer number) {
        return number >= startNumber && number <= endNumber;
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
