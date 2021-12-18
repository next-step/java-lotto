package lotto.domain;

import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoRankTest {

    @DisplayName("로또 당첨 번호와 일치하는 로또번호 개수는 개수와 보너스 당첨 여부를 인자로 전달하면 로또 당첨금을 알 수 있다.")
    @MethodSource("provideLottoValues")
    @ParameterizedTest
    void valueOf(int numberOfMatch, boolean matchesBonus, int winningPrize) {
        assertThat(LottoRank.valueOf(numberOfMatch, matchesBonus).winningPrize()).isEqualTo(winningPrize);
    }

    private static Stream<Arguments> provideLottoValues() {
        return Stream.of(
                Arguments.of(6, true, 2_000_000_000),
                Arguments.of(6, false, 2_000_000_000),
                Arguments.of(5, true, 30_000_000),
                Arguments.of(5, false, 1_500_000),
                Arguments.of(4, true, 50_000),
                Arguments.of(4, false, 50_000),
                Arguments.of(3, true, 5_000),
                Arguments.of(3, false, 5_000),
                Arguments.of(2, false, 0),
                Arguments.of(2, true, 0),
                Arguments.of(1, false, 0),
                Arguments.of(1, true, 0),
                Arguments.of(0, false, 0),
                Arguments.of(0, true, 0)
        );
    }

    @DisplayName("로또 당첨 번호와 일치하는 로또 번호 개수는 0과 6개 사이다.")
    @ValueSource(ints = {-1, 7})
    @ParameterizedTest
    void valueOfValidation(int numberOfMatch) {
        assertThatThrownBy(() -> LottoRank.valueOf(numberOfMatch, true)).isInstanceOf(LottoException.class);
    }

}