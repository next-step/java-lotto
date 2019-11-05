package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * Created by yusik on 2019/11/05.
 */
public class NumberGenerator {

    private static final int DEFAULT_START_NUMBER = 1;
    private static final int DEFAULT_END_NUMBER = 45;

    private final List<Integer> base;

    public NumberGenerator() {
        this(DEFAULT_START_NUMBER, DEFAULT_END_NUMBER);
    }

    public NumberGenerator(int start, int end) {
        base = IntStream
                .range(start, end + 1)
                .boxed()
                .collect(toList());
    }

    public List<Integer> generate(int limit) {
        Collections.shuffle(base);
        return base.stream()
                .limit(limit)
                .sorted()
                .collect(toList());
    }

}
