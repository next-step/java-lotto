package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumbersGenerator {

    public static List<Integer> autoGenerate() {
        List<Integer> numbers = IntStream.rangeClosed(1, 45)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(numbers);
        return numbers.stream()
                .limit(6)
                .collect(Collectors.toList());
   }
}
