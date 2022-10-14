package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    private static Stream<Arguments> provideLottoMatch() {
        return Stream.of(
                Arguments.of(new Lotto(LottoNumberSet.createLottoNumbers(1, 2, 3, 4, 5, 6)), 1),
                Arguments.of(new Lotto(LottoNumberSet.createLottoNumbers(2, 3, 4, 5, 6, 7)), 2),
                Arguments.of(new Lotto(LottoNumberSet.createLottoNumbers(2, 3, 4, 5, 6, 8)), 3),
                Arguments.of(new Lotto(LottoNumberSet.createLottoNumbers(3, 4, 5, 6, 7, 8)), 4),
                Arguments.of(new Lotto(LottoNumberSet.createLottoNumbers(4, 5, 6, 7, 8, 9)), 5),
                Arguments.of(new Lotto(LottoNumberSet.createLottoNumbers(5, 6, 7, 8, 9, 10)), 0),
                Arguments.of(new Lotto(LottoNumberSet.createLottoNumbers(6, 7, 8, 9, 10, 11)), 0),
                Arguments.of(new Lotto(LottoNumberSet.createLottoNumbers(7, 8, 9, 10, 11, 12)), 0)
        );
    }

    @ParameterizedTest(name = "로또 등수를 반환한다.")
    @MethodSource(value = "provideLottoMatch")
    void match(Lotto lotto, int matchCount) {
        LottoWinner winner = new LottoWinner(LottoNumberSet.createLottoNumbers(new int[]{1, 2, 3, 4, 5, 6}), new LottoNumber(7));

        assertThat(winner.rank(lotto)).isEqualTo(matchCount);
    }

}