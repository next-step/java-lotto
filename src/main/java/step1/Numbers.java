package step1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Numbers {
    private List<Integer> numbers = new ArrayList<>();

    public Numbers() {

    }

    public Numbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public void addNumber(String element) {
        numbers.add(Integer.parseInt(element));
    }

    public boolean hasNumber() {
        return numbers.size() != 0;
    }

    public int getNumber(int index) {
        return numbers.get(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Numbers numbers1 = (Numbers) o;
        return Objects.equals(numbers, numbers1.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    public int size() {
        return numbers.size();
    }
}
