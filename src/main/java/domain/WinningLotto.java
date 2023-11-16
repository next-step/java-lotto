package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {

    private static final int LOTTO_NUMBER_COUNT_LIMIT = 6;
    private static final String PATTERN = ",";
    private List<Integer> winnerNumbers;

    public WinningLotto(Integer... input) {
        this(Arrays.asList(input));
    }

    public WinningLotto(String winningNumber) {
        this(Arrays.stream(winningNumber.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
    }
    public WinningLotto(List<Integer> numbers) {
        if (numbers.size() < LOTTO_NUMBER_COUNT_LIMIT) {
            throw new IllegalArgumentException("로또 숫자는 6개 입력이 필요합니다.");
        }
        this.winnerNumbers = numbers;
    }

    public List<Integer> getWinnerNumbers() {
        return winnerNumbers;
    }

}
