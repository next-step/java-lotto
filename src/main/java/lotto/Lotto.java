package lotto;

import java.util.List;
import java.util.Objects;

public class Lotto {

    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }


    public int matchCount(List<Integer> numberList){
        return matchNumber(numberList).size();
    }


    private List<Integer> matchNumber(List<Integer> numberList){
        numberList.retainAll(this.numbers);
        return numberList;
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
