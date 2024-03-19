package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ContainsTest {

    @Test
    void contains() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> integers1 = Arrays.asList(1, 2, 3, 7, 8, 9);

        Assertions.assertThat(integers.contains(integers1.get(0))).isTrue();
    }
}
