package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class ShuffleNumberGenerator implements LottoNumberGenerator{
    @Override
    public List<Integer> generate() {
        List<Integer> numbers = IntStream.rangeClosed(1, 45)
            .collect(ArrayList::new, List::add, List::addAll);
        Collections.shuffle(numbers);
        return numbers.subList(0, 6);
    }
}
