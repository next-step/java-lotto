package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class LottoMachine {

    List<Integer> generate() {

        List<Integer> numbers = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());

        Collections.shuffle(numbers);

        return Collections.unmodifiableList(numbers.subList(0, 6));
    }
}
