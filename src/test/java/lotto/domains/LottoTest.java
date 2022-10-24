package lotto.domains;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoTest {
    @ParameterizedTest
    @MethodSource("parametersProvider")
    void Given_LottoAndWinner_When_GetPrize_Then_EqualsTo_Expected(Lotto lotto, Prize expected) {
        LottoWinner winner = new LottoWinner(Lotto.createByString("1, 2, 3, 4, 5, 6"), LottoNumber.of(7));

        assertThat(lotto.getPrize(winner)).isEqualTo(expected);
    }

    @Test
    void Given_Duplicated_Numbers_When_Create_Lotto_Then_Fail() {
        assertThatIllegalArgumentException().isThrownBy(() -> Lotto.createByString("1, 1, 2, 3, 4, 5"));
    }

    static Stream<Arguments> parametersProvider() {
        return Stream.of(
                arguments(Lotto.createByString("10, 11, 12, 13, 14, 15"), Prize.NONE),
                arguments(Lotto.createByString("1, 2, 7, 10, 11, 12"), Prize.NONE),
                arguments(Lotto.createByString("1, 2, 3, 10, 11, 12"), Prize.FIFTH),
                arguments(Lotto.createByString("1, 2, 3, 4, 10, 11"), Prize.FOURTH),
                arguments(Lotto.createByString("1, 2, 3, 4, 5, 10"), Prize.THIRD),
                arguments(Lotto.createByString("1, 2, 3, 4, 5, 7"), Prize.SECOND),
                arguments(Lotto.createByString("1, 2, 3, 4, 5, 6"), Prize.FIRST)
        );
    }
}
