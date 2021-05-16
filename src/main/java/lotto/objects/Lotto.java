package lotto.objects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private List<Integer> numbers;

    public Lotto() {
        this.numbers = new ArrayList<>();
    }

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        Collections.sort(numbers);

        return numbers;
    }

    public void addNumber(int number) {
        numbers.add(number);
    }

}
