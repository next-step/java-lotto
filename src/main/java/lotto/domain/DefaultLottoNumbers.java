package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.utils.Constants.NUMBER_FORTY_FIVE;
import static lotto.utils.Constants.NUMBER_ONE;

public class DefaultLottoNumbers {
    private final List<Integer> defaultLottoNumbers;

    public DefaultLottoNumbers() {
        defaultLottoNumbers = IntStream.rangeClosed(NUMBER_ONE, NUMBER_FORTY_FIVE)
                .boxed().collect(Collectors.toList());
    }

    public void shuffleNumbers() {
        Collections.shuffle(defaultLottoNumbers);
    }

    public Integer getDefaultLottoNumberByIndex(int index) {
        return defaultLottoNumbers.get(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultLottoNumbers that = (DefaultLottoNumbers) o;
        return Objects.equals(defaultLottoNumbers, that.defaultLottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(defaultLottoNumbers);
    }
}
