package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Lotto {

    private List<LottoNumber> numbers;

    public Lotto() {}

    public Lotto(List<Integer> numbers) {
        mapLottoNumbers(numbers);
    }

    private void mapLottoNumbers(List<Integer> numbers) {
        this.numbers = numbers.stream()
            .map(LottoNumber::new)
            .sorted()
            .collect(Collectors.toList());
    }

    public List<LottoNumber> numbers() {
        return numbers;
    }

    public int size() {
        return numbers.size();
    }

    public int countMatchingWinningLotto(Lotto lotto) {
        return lotto.numbers.stream()  
            .filter(numbers::contains)  
            .count();  
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
