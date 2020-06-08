package step2.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class UserLottoTest {


    private static Stream<Arguments> setPrizeTestCase() {
        return Stream.of(
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 7, Prize.FIRST.getGrade()), // 6 + 0
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 16), 6, Prize.SECOND.getGrade()), // 5 + 1
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 16), 7, Prize.THIRD.getGrade()), // 5 + 0
            Arguments.of(Arrays.asList(1, 2, 3, 4, 15, 16), 5, Prize.FORTH.getGrade()), // 4 + 1/0
            Arguments.of(Arrays.asList(1, 2, 3, 14, 15, 16), 4, Prize.FIFTH.getGrade()), // 3 + 1/0
            Arguments.of(Arrays.asList(1, 2, 13, 14, 15, 16), 4, Prize.NONE.getGrade()),  // 2 + 1/0
            Arguments.of(Arrays.asList(1, 12, 13, 14, 15, 16), 4, Prize.NONE.getGrade()), // 1 + 1/0
            Arguments.of(Arrays.asList(11, 12, 13, 14, 15, 16), 4, Prize.NONE.getGrade()) // 0 + 1/0
        );
    }

    @ParameterizedTest
    @MethodSource("setPrizeTestCase")
    public void setPrizeTest(List<Integer> winningLottos, int bonusNumber, int expected) {
        //given
        UserLotto lotto = new UserLotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        //when
        lotto.setPrize(new WinningLotto(winningLottos, bonusNumber));

        //then
        assertThat(lotto.getPrize()).isEqualTo(expected);
    }
}