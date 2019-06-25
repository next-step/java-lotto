package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by wyparks2@gmail.com on 2019-06-26
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class WinningNumbersTest {
    private List<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void 당첨번호_생성(int input) {
        WinningNumbers winningNumbers = new WinningNumbers(numbers);

        assertThat(winningNumbers.contains(input)).isTrue();
    }

    @Test
    void 당첨번호_6개_생성() {
        WinningNumbers winningNumbers = new WinningNumbers(numbers);

        assertThat(winningNumbers.size()).isEqualTo(6);
    }
}
