package lotto;

import java.util.List;
import java.util.Objects;
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
        return (int) lotto.numbers.stream()  
            .filter(numbers::contains)  
            .count();  
    }

    public boolean matchBonusNumber(LottoNumber bonus) {
        return numbers.contains(bonus);
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
