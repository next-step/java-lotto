package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private final List<LottoNumber> numbers;

    public static Lotto from(final String lottoString) {
        List<LottoNumber> numbers = Arrays.stream(lottoString.split(","))
                                            .map(s -> s.trim())
                                            .map(LottoNumber::new)
                                            .collect(Collectors.toList());
        return new Lotto(numbers);
    }
    public Lotto(final List<LottoNumber> numbers) {
        Collections.sort(numbers);
        this.numbers = Collections.unmodifiableList(numbers);
    }

    public long sameLottoNumberCount(Lotto lotto) {
        return this.numbers.stream()
                .filter(lotto.numbers::contains)
                .count();
    }

    public String showLottoNumber() {
        return this.numbers.stream()
                        .map(LottoNumber::getNumberString)
                        .collect(Collectors.joining(", "));
    }

}
