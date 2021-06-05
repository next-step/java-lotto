package lotto.lotto;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningNumber {
    private final Set<LottoNumber> numbers;

    public WinningNumber(Lotto lotto) {
        this.numbers = lotto.numbers();
    }

    public static WinningNumber of(int... numbers) {
        return new WinningNumber(new Lotto(Arrays.stream(numbers).boxed().collect(Collectors.toList())));
    }

    public Set<LottoNumber> numbers() {
        return numbers;
    }

    public boolean contains(LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }
}