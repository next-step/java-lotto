package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {

    private Numbers numbers;

    public Lotto() {
        numbers = new Numbers();
        numbers.marked();
    }

    public Lotto(List<Integer> answer) {
        numbers = new Numbers(answer);
    }

    public List<Integer> getNumbers() {
        List<Integer> numbers = this.numbers.getNumbers();
        Collections.sort(numbers);
        return numbers;
    }

    public int matchCount(Lotto ticket) {
        int count = 0;
        List<Integer> numbers = ticket.getNumbers();
        for (int number : numbers) {
            count = getCount(count, number);
        }
        return count;
    }

    private int getCount(int count, int number) {
        if (this.numbers.contains(number)) {
            count++;
        }
        return count;
    }


}
