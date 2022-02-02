package lotto.domain.lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private List<LottoNumber> numbers;

    private Lotto(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public static Lotto from(List<Integer> numbers) {
        return new Lotto(numbers.stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList()));
    }
}
