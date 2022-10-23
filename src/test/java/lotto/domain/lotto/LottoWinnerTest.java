package lotto.domain.lotto;

import lotto.domain.rank.Rank;
import lotto.domain.lottonumber.LottoNumber;
import lotto.domain.lottonumber.LottoNumberSet;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class LottoWinnerTest {

    @Test
    void valid() {
        assertThatThrownBy(
                () -> new LottoWinner(new LottoNumberSet(1, 2, 3, 4, 5, 6), LottoNumber.get(6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideLottoMatch() {
        return Stream.of(
                Arguments.of(new Lotto(1, 2, 3, 4, 5, 6), Rank.FIRST),
                Arguments.of(new Lotto(2, 3, 4, 5, 6, 7), Rank.SECOND),
                Arguments.of(new Lotto(2, 3, 4, 5, 6, 8), Rank.THIRD),
                Arguments.of(new Lotto(3, 4, 5, 6, 7, 8), Rank.FOURTH),
                Arguments.of(new Lotto(4, 5, 6, 7, 8, 9), Rank.FIFTH)
        );
    }

    @ParameterizedTest(name = "로또 등수를 반환한다.")
    @MethodSource(value = "provideLottoMatch")
    void match(Lotto lotto, Rank rank) {
        LottoWinner winner = new LottoWinner(new LottoNumberSet(1, 2, 3, 4, 5, 6), LottoNumber.get(7));

        assertThat(winner.rank(lotto)).isEqualTo(rank);
    }
}
