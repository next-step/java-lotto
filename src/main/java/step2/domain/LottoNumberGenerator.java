package step2.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberGenerator implements NumberGenerator {

    public List<Integer> getGeneratedNumbers(List<Integer> numbers) {
        Collections.shuffle(numbers);

        return numbers.stream()
                .limit(6)
                .collect(Collectors.toList());
    }
}
