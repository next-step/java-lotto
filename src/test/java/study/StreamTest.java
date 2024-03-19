package study;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class StreamTest {

    @Test
    void distinct() {
        List<Integer> integers = Arrays.asList(1, 1, 1, 1, 1);

        List<Integer> distinctIntegers = integers.stream().distinct().collect(Collectors.toList());

        assertThat(distinctIntegers.size()).isEqualTo(1);
    }

}
