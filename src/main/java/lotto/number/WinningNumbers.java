package lotto.number;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {

    private final List<LottoNumber> numbers;

    public WinningNumbers(int... numbers) {
        this(Arrays.stream(numbers).mapToObj(LottoNumber::new).collect(Collectors.toList()));
    }

    public WinningNumbers(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public static WinningNumbers getInstanceByInt(List<Integer> numbers) {
        return new WinningNumbers(numbers.stream().map(LottoNumber::new).collect(Collectors.toList()));
    }

    List<LottoNumber> value() {
        return numbers;
    }

}
