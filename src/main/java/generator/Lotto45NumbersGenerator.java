package generator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto45NumbersGenerator implements LottoNumbersGenerator {

    private static final int MINIMUM_LOTTO_NUMBER = 1;

    private static final int MAXIMUM_LOTTO_NUMBER = 46;

    @Override
    public List<Integer> generate() {
        return IntStream.range(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }
}
