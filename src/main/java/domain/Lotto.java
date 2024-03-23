package domain;

import java.util.List;

public class Lotto {

    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int numberCheck(List<Integer> winNumbers) {
        int cnt = 0;
        for (Integer winNumber : winNumbers) {
            if (numbers.contains(winNumber))
                cnt++;
        }
        return cnt;
    }
}
