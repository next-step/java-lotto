package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Numbers {

    private List<Number> numbers = new ArrayList<>();

    public int size() {
        return numbers.size();
    }

    public int match(Numbers other) {
        return (int) numbers.stream()
                .filter(other.numbers::contains)
                .count();
    }

    public boolean contains(Number number) {
        return this.numbers.contains(number);
    }

    public boolean match(Numbers other, Numbers bonus) {
        for (Number number : numbers) {
            if (!other.contains(number) && bonus.contains(number)) {
                return true;
            }
        }

        return false;
    }

    public static Numbers createNumbers(List<Integer> datas) {
        List<Number> numberList = datas.stream()
                .map(Number::new)
                .collect(Collectors.toList());
        return new Numbers(numberList);
    }

    public Numbers(List<Number> numberList) {
        numbers.addAll(numberList);
        sort();
    }

    private void sort() {
        Collections.sort(numbers);
    }

    @Override
    public String toString() {
        return String.valueOf(numbers);
    }

}
