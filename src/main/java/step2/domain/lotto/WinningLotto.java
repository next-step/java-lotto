package step2.domain.lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto extends NormalLotto {
    private static int COUNT = 7;

    private final List<Integer> numbers;
    private final int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        if (!valid(numbers, bonusNumber)) throw new IllegalArgumentException();
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public WinningLotto(String rawNumbers, int bonusNumber) {
        this(Arrays.stream(rawNumbers.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList()), bonusNumber);
    }

    private boolean valid(List<Integer> numbers, int bonusNumber) {
        return inBoundary(numbers, bonusNumber) && unique(numbers, bonusNumber);
    }

    private boolean unique(List<Integer> numbers, int bonusNumber) {
        HashSet<Integer> hashSet = new HashSet<>(numbers);
        hashSet.add(bonusNumber);
        return hashSet.size() == COUNT;
    }

    private boolean inBoundary(List<Integer> numbers, int bonusNumber) {
        boolean validFlag = true;
        for (Integer number : numbers) {
            validFlag &= (number >= 1 && number <= UPPER_BOUND);
        }
        if (bonusNumber < 1 || bonusNumber > UPPER_BOUND) {
            validFlag = false;
        }
        return validFlag;
    }
}
