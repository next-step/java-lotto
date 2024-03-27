package domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Collections.sort(numbers);
        this.numbers = numbers;
    }


    public int numberCheck(Lotto winNumbers) {
        int cnt = 0;
        for (Integer winNumber : winNumbers.numbers) {
            if (numbers.contains(winNumber))
                cnt++;
        }
        return cnt;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
