package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoWinnerNumber {
    private static final String COMMA = ",";
    private List<Number> winnerNumbers = new ArrayList<>();

    public LottoWinnerNumber() {
    }

    public LottoWinnerNumber(List<Number> winnerNumbers) {
        this.winnerNumbers = winnerNumbers;
    }

    public void splitStringNumbers(String inputPrizeNumbers) {
        String[] numbers = inputPrizeNumbers.trim().split(COMMA);
        createWinnerNumbers(numbers);
    }

    private void createWinnerNumbers(String[] numbers) {
        Arrays.stream(numbers)
        .mapToInt(Integer::parseInt)
        .forEach(number -> winnerNumbers.add(new Number(number)));
    }

    public boolean validateContainsNumber(Number number) {
        return winnerNumbers.stream()
                .map(Number::getNumber)
                .anyMatch(winnerNumber -> number.checkWinnerNumber(number, winnerNumber));
    }
}
