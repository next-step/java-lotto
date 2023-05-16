package lottery;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class LotteryRowInputView {
    private final Set<Integer> numbers;

    public LotteryRowInputView(String input) {
        numbers = Arrays.stream(input.replace(" ", "").split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }
}
