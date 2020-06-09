package step2.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class UserLottoTest {


    private static Stream<Arguments> getPrizeTestCase() {
        return Stream.of(
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 7, Prize.FIRST), // 6 + 0
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 16), 6, Prize.SECOND), // 5 + 1
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 16), 7, Prize.THIRD), // 5 + 0
            Arguments.of(Arrays.asList(1, 2, 3, 4, 15, 16), 5, Prize.FORTH), // 4 + 1/0
            Arguments.of(Arrays.asList(1, 2, 3, 14, 15, 16), 4, Prize.FIFTH), // 3 + 1/0
            Arguments.of(Arrays.asList(1, 2, 13, 14, 15, 16), 4, Prize.NONE),  // 2 + 1/0
            Arguments.of(Arrays.asList(1, 12, 13, 14, 15, 16), 4, Prize.NONE), // 1 + 1/0
            Arguments.of(Arrays.asList(11, 12, 13, 14, 15, 16), 4, Prize.NONE) // 0 + 1/0
        );
    }

    @ParameterizedTest
    @MethodSource("getPrizeTestCase")
    public void getPrizeTest(List<Integer> winningLottos, int bonusNumber, Prize expected) {
        //given
        UserLotto lotto = new UserLotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        //when
        Prize prize = lotto.getPrize(new WinningLotto(winningLottos, bonusNumber));

        //then
        assertThat(prize).isEqualTo(expected);
    }
}