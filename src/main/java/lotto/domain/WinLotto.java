package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinLotto {
    private final List<Number> numbers;

    public WinLotto(int... numbers) {
        this.numbers = Arrays.stream(numbers).mapToObj(Number::new).sorted().collect(Collectors.toList());
    }

    public WinType confirmWin(Lotto lotto) {
        long count = lotto.numbers().stream().filter(numbers::contains).count();
        return WinType.find(count);
    }
}
