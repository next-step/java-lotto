package LottoTest;

import lotto.Lotto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {
    @Test
    void When_New_Then_InstanceCreated() {
        //when
        Lotto lotto = new Lotto();

        //then
        //no compile error
    }

    @Test
    void Given_LottoNumber_When_New_Then_InstanceCreated() {
        //given
        List<Integer> givenLottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        //when
        Lotto lotto = new Lotto(givenLottoNumbers);

        //then
        assertThat(lotto).isEqualTo(new Lotto(givenLottoNumbers));
    }

    @ParameterizedTest
    @MethodSource("provideWinningNumbers")
    void Given_WinningNumbers_When_Match_Then_NumberOfMatchedNumbers(List<Integer> winningNumbers, int expected) {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        //when
        int winners = lotto.matches(winningNumbers);

        //then
        assertThat(winners).isEqualTo(expected);
    }

    private static Stream<Arguments> provideWinningNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 6),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 7), 5),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 8, 7), 4),
                Arguments.of(Arrays.asList(1, 2, 3, 9, 8, 7), 3),
                Arguments.of(Arrays.asList(1, 2, 10, 9, 8, 7), 2),
                Arguments.of(Arrays.asList(1, 11, 10, 9, 8, 7), 1),
                Arguments.of(Arrays.asList(12, 11, 10, 9, 8, 7), 0)
        );
    }
}
