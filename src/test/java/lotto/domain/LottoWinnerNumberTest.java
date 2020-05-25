package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoWinnerNumberTest {

    @DisplayName("당첨자 번호와 보너스 번호가 중복되는 경우 Exception")
    @Test
    void overlapWinnerNumberAndBonusNumber() {
        assertThatThrownBy(() -> this.createLottoWinnerNumber(1, 7, 1))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @ParameterizedTest
    @MethodSource("provideNotValidWinner")
    @DisplayName("지난 주 당첨 번호가 6개가 아닌경우 Exception")
    void validateNotValidWinner(int min, int max, int bonusBall) {
        assertThatThrownBy(() -> this.createLottoWinnerNumber(min, max, bonusBall))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideNotValidWinner() {
        return Stream.of(
                Arguments.of(1, 5, 1),
                Arguments.of(1, 4, 5),
                Arguments.of(1, 3, 5),
                Arguments.of(1, 2, 5),
                Arguments.of(1, 1, 5)
        );
    }

    private LottoWinnerNumber createLottoWinnerNumber(int min, int max, int bonusBall) {
        List<Lotto> winner = IntStream.range(min, max)
                .mapToObj(number -> new Lotto(number))
                .collect(Collectors.toList());
        return new LottoWinnerNumber(winner, new Lotto(bonusBall));
    }
}