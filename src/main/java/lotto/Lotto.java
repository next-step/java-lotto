package lotto;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.rangeClosed;

public class Lotto {
    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final List<Integer> NUMBERS = rangeClosed(MIN, MAX).boxed().collect(toList());

    private final LottoNumbers lottoNumbers;

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public Lotto() {
        this.lottoNumbers = pickLottoNumbers();
    }

    private LottoNumbers pickLottoNumbers() {
        Collections.shuffle(NUMBERS);

        List<LottoNumber> pickedNumbers = NUMBERS.stream()
                .limit(6)
                .sorted()
                .map(LottoNumber::new)
                .collect(toList());

        return new LottoNumbers(pickedNumbers);
    }

    public LottoNumbers lottoNumbers() {
        return this.lottoNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "lottoNumbers=" + lottoNumbers +
                '}';
    }
}
