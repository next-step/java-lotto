package step022;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static step022.LottoConfig.*;

public abstract class MakeNumberRule {
    List<Integer> integers = IntStream.range(NUMBER_RANGE_START, NUMBER_RANGE_END).boxed().collect(Collectors.toList());

    public abstract List<Integer> makeNumbers();

}
