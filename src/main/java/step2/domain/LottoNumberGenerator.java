package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {

    public static List<Integer> issueNumbers(int upperbound, int count) {
        if (count > upperbound) throw new IllegalArgumentException();

        return IntStream.rangeClosed(1, upperbound)
                .boxed()
                .collect(toShuffledList())
                .subList(0, count)
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private static final Collector<?, ?, ?> SHUFFLER = Collectors.collectingAndThen(
            Collectors.toCollection(ArrayList::new),
            list -> {
                Collections.shuffle(list);
                return list;
            }
    );

    @SuppressWarnings("unchecked")
    private static <T> Collector<T, T, List<T>> toShuffledList() {
        return (Collector<T, T, List<T>>) SHUFFLER;
    }

}
