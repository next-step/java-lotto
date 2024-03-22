package lottogame;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {

    @ParameterizedTest
    @MethodSource("lottoAndCountOfWinner")
    void 로또_당첨(Lotto winnerLotto, Lotto lotto, int countOfWinner) {
        assertThat(winnerLotto.match(lotto)).isEqualTo(countOfWinner);
    }

    static Stream<Arguments> lottoAndCountOfWinner() {
        return Stream.of(
                Arguments.arguments(new Lotto(List.of(1, 4, 5, 6, 7, 8)), new Lotto(List.of(1, 4, 5, 6, 7, 8)), 6),
                Arguments.arguments(new Lotto(List.of(1, 4, 5, 6, 7, 8)), new Lotto(List.of(1, 4, 5, 6, 7, 14)), 5),
                Arguments.arguments(new Lotto(List.of(1, 4, 5, 6, 7, 8)), new Lotto(List.of(1, 4, 5, 6, 14, 17)), 4),
                Arguments.arguments(new Lotto(List.of(1, 4, 5, 6, 7, 8)), new Lotto(List.of(1, 4, 5, 14, 17, 21)), 3)
        );
    }
}