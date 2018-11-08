package lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoTicket {
    private List<Integer> numbers = null;
    
    public LottoTicket(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }


    public int howManyNumber(List<Integer> otherNumber) {
        int count = 0;
        for (Integer number : otherNumber) {
            if (isMatch(number)) {
                count++;
            }
        }
        return count;
    }

    private boolean isMatch(int number) {
        if (numbers.contains(number)) {
            return true;
        }
        return false;
    }
    

    @Override
    public String toString() {
        return numbers.toString();
    }
}
