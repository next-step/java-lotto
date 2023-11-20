package lottoModel;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private Set<Integer> numbers;

    public Set<Integer> getNumbers() {
        return numbers;
    }

    public Lotto(Set<Integer> numbers) {
        this.numbers = numbers;
    }

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers.stream().collect(Collectors.toSet());
    }


    public int matchCount(List<Integer> numberList) {
        return matchNumber(numberList.stream().collect(Collectors.toSet())).size();
    }

    private Set<Integer> matchNumber(Set<Integer> numberList) {
        return findCommonElements(numberList, this.numbers);
    }

    private static Set<Integer> findCommonElements(Set<Integer> first, Set<Integer> second) {
        return first.stream().filter(second::contains).collect(Collectors.toSet());
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

    @Override
    public String toString() {
        return numbers.toString();
    }

    public boolean isContainBonus(int bonusNumber){
        return this.numbers.contains(bonusNumber);
    }
}
