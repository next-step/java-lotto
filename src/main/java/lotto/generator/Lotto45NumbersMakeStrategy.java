package lotto.generator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto45NumbersMakeStrategy implements LottoNumbersMakeStrategy {

    private static final int MINIMUM_LOTTO_NUMBER = 1;

    private static final int MAXIMUM_LOTTO_NUMBER = 45;

    public static final int PICK_NUMBERS = 6;

    private static final List<Integer> LOTTO_NUMBERS = IntStream.rangeClosed(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER)
            .boxed()
            .collect(Collectors.toList());

    @Override
    public List<Integer> makeLottoNumber() {
        Collections.shuffle(LOTTO_NUMBERS);

        return LOTTO_NUMBERS.stream()
                .limit(PICK_NUMBERS)
                .collect(Collectors.toList());
    }

}
