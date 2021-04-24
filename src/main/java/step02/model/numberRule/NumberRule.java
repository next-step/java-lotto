package step02.model.numberRule;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static step02.utils.LottoConfig.*;

public abstract class NumberRule {
    static final List<Integer> INTEGERS = IntStream
            .range(NUMBER_RANGE_START, NUMBER_RANGE_END)
            .boxed()
            .collect(Collectors.toList());

    public abstract List<Integer> makeNumbers();

}
