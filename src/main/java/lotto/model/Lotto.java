package lotto.model;

import java.util.List;

public class Lotto {


    private List<Integer> numbers;


    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (!hasSixNumbers(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean hasSixNumbers(List<Integer> numbers) {
        return numbers.size() == 6;
    }


    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getWinningCount(List<Integer> winningNumbers) {

        int winningCount = 0;

        for (Integer winnerNumber : winningNumbers) {
            if (this.numbers.contains(winnerNumber)) {
                winningCount++;
            }
        }
        return winningCount;
    }
}
