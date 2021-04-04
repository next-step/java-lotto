package step02;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static step02.LottoConfig.*;

public abstract class NumberRule {
    List<Integer> integers = IntStream.range(NUMBER_RANGE_START, NUMBER_RANGE_END).boxed().collect(Collectors.toList());

    public abstract List<Integer> makeNumbers();

}
