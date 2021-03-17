package step2.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseLottoNumberGenerator implements NumberGenerator {
    @Override
    public List<Integer> getGeneratedNumbers(List<Integer> numbers) {
        Collections.reverse(numbers);
        return numbers.stream()
                .limit(6)
                .collect(Collectors.toList());
    }
}
