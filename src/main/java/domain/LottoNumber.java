package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {
    static final int START_NUMBER = 1;
    static final int END_NUMBER = 45;

    private static final List<Integer> numbers =
            IntStream.rangeClosed(START_NUMBER, END_NUMBER)
                    .boxed()
                    .collect(Collectors.toList());

    public static List<Integer> instance() {
        return Collections.unmodifiableList(numbers);
    }

}
