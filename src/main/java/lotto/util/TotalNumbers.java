package lotto.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lotto.domain.Number;

public class TotalNumbers {
    public static List<Number> NUMBERS = IntStream.rangeClosed(1, 45)
            .mapToObj(Number::new)
            .collect(Collectors.toList());
}
