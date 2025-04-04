package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoLottoNumberGenerator implements LottoNumberGenerator {
    @Override
    public List<LottoNumber> generate() {
        List<LottoNumber> numbers = IntStream.rangeClosed(1, 45)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
        Collections.shuffle(numbers);
        return numbers.subList(0, 6);
    }
}
