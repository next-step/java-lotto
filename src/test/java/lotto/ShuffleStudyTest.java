package lotto;

import lotto.domain.Number;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ShuffleStudyTest {

    @Test
    @DisplayName("shuffle 테스트")
    void test01() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Collections.shuffle(numbers);

        System.out.println(numbers);
    }

    @Test
    @DisplayName("shuffle (1 - 45) Number 테스트")
    void test02() {
        List<Number> numbers = IntStream.range(1, 45).mapToObj(Number::new).collect(Collectors.toList());
        Collections.shuffle(numbers);

        System.out.println(numbers);
    }
}
