package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Ticket {

    private Numbers numbers;

    public Ticket() {
        numbers = new Numbers();
        numbers.marked();
    }

    public Ticket(List<Integer> answer) {
        numbers = new Numbers(answer);
    }

    public List<Integer> getNumbers() {
        List<Integer> numbers = this.numbers.getNumbers();
        Collections.sort(numbers);
        return numbers;
    }

    public int matchCount(Ticket ticket) {
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
