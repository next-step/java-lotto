package lotto.domain2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lotto {
    private static final int NUMBER_COUNT = 6;
    private final List<LottoNumber> lottoNumbers;

    public Lotto(final List<Integer> numbers) {
        if (NUMBER_COUNT != numbers.size()) {
            throw new IllegalArgumentException(String.format("로또번호의 개수는 %s개만 가능합니다. 입력받은 로또번호 개수 = %s", NUMBER_COUNT, numbers.size()));
        }

        this.lottoNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            lottoNumbers.add(LottoNumber.of(number));
        }
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
}
