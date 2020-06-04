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
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), Prize.FIRST.getGrade()),
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 16), Prize.SECOND.getGrade()),
            Arguments.of(Arrays.asList(1, 2, 3, 4, 15, 16), Prize.THIRD.getGrade()),
            Arguments.of(Arrays.asList(1, 2, 3, 14, 15, 16), Prize.FORTH.getGrade()),
            Arguments.of(Arrays.asList(1, 2, 13, 14, 15, 16), Prize.NONE.getGrade()),
            Arguments.of(Arrays.asList(1, 12, 13, 14, 15, 16), Prize.NONE.getGrade()),
            Arguments.of(Arrays.asList(11, 12, 13, 14, 15, 16), Prize.NONE.getGrade())
        );
    }

    @ParameterizedTest
    @MethodSource("setPrizeTestCase")
    public void setPrizeTest(List<Integer> winningLottos, int expected) {
        //given
        UserLotto lotto = new UserLotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        //when
        lotto.setPrize(winningLottos);

        //then
        assertThat(lotto.getPrize()).isEqualTo(expected);
    }
}