package kr.heesu.calculator.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ArgumentsTest {

    @Test
    void hasNextTest() {
        List<Integer> nums = new ArrayList<>(Arrays.asList(1, 2));

        Arguments args = Arguments.of(nums);

        assertThat(args.hasNext()).isTrue();
        assertThat(args.nextArgument()).isEqualTo(1);
        assertThat(args.hasNext()).isTrue();
        assertThat(args.nextArgument()).isEqualTo(2);
        assertThat(args.hasNext()).isFalse();
    }
}
