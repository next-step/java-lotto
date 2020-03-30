package lotto;

import java.util.Set;

public class ResultView {
    private final Numbers numbers;

    public ResultView(String inputText) {
        numbers = getParsedNumbers(inputText);
    }

    public Set<Integer> winnerNumber() {
        return numbers.getNumbers();
    }

    private Numbers getParsedNumbers(String inputText) {
        return new Parser(inputText).getNumbers();
    }

}
