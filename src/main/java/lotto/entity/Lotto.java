package lotto.entity;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers){
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int matchCount(List<Integer> winningNumbers) {
        Collections.sort(winningNumbers);

        int winningCount = 0;

        for (Integer winningNumber : winningNumbers) {
            for(Integer number : this.numbers){
                if(winningNumber.equals(number)){
                    winningCount++;
                    continue;
                }
            }
        }
        return winningCount;
    }
}
