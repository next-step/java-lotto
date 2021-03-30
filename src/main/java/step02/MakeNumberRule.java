package step02;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static step02.Config.*;

public interface MakeNumberRule {

    List<Integer> integers = IntStream.range(NUMBER_RANGE_START, NUMBER_RANGE_END).boxed().collect(Collectors.toList());

    List<Integer> makeNumbers();
}
