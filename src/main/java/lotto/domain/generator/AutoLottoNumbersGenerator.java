package lotto.domain.generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by wyparks2@gmail.com on 2019-06-25
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class AutoLottoNumbersGenerator implements LottoNumbersGenerator {
    private static final List<Integer> ALLOWED_NUMBERS;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int MAX_SIZE = 6;

    static {
        ALLOWED_NUMBERS = IntStream.rangeClosed(START_NUMBER, END_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }

    @Override
    public List<Integer> generate() {
        List<Integer> tempNumbers = new ArrayList<>(ALLOWED_NUMBERS);
        Collections.shuffle(tempNumbers);

        return tempNumbers.stream()
                .limit(MAX_SIZE)
//                .sorted()
                .collect(Collectors.toList());
    }
}
