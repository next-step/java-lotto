package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoNumber {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int NUMBER_OF_DRAWS = 6;
    private static final int ZERO = 0;

    private final List<Integer> lottoNumbers;

    public LottoNumber() {
        this.lottoNumbers = createLottoNumber();
    }

    private static List<Integer> createLottoNumber() {
        List<Integer> numbers = createFromMinToMaxNumber();
        Collections.shuffle(numbers);
        Collections.sort(numbers.subList(ZERO, NUMBER_OF_DRAWS));
        return numbers.subList(ZERO, NUMBER_OF_DRAWS);
    }

    private static List<Integer> createFromMinToMaxNumber() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            numbers.add(i);
        }
        return numbers;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return Objects.equals(getLottoNumbers(), that.getLottoNumbers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLottoNumbers());
    }

    @Override
    public String toString() {
        return "LottoNumber{" +
                "lottoNumbers=" + lottoNumbers +
                '}';
    }
}
