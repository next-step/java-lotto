package lotto;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class ResultView {
    private static final String SPLIT_TEXT = ",";

    private LottoNumber winningNumbers;

    public ResultView(String inputText) {
        Set<Integer> numbers = splitWinningNumber(inputText);
        winningNumbers = new LottoNumber(numbers);

    }

    private Set<Integer> splitWinningNumber(String inputText) {
        return Arrays
                .stream(inputText.split(SPLIT_TEXT))
                .map(num -> Integer.parseInt(num))
                .collect(Collectors.toSet());
    }


}
