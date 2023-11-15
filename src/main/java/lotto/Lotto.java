package lotto;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }


    public int matchCount(List<Integer> numberList){
        return matchNumber(numberList).size();
    }


    private Set<Integer> matchNumber(List<Integer> numberList){
        return findCommonElements(numberList, this.numbers);
    }

    private static <T> Set<T> findCommonElements(List<T> first, List<T> second) {
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
        return numbers.toString() ;
    }
}
