package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    private static Stream<Arguments> provideLottoMatch() {
        return Stream.of(
                Arguments.of(new Lotto(LottoNumberSet.createLottoNumbers(new int[]{1, 2, 3, 4, 5, 6})), 1),
                Arguments.of(new Lotto(LottoNumberSet.createLottoNumbers(new int[]{2, 3, 4, 5, 6, 7})), 3),
                Arguments.of(new Lotto(LottoNumberSet.createLottoNumbers(new int[]{3, 4, 5, 6, 7, 8})), 4),
                Arguments.of(new Lotto(LottoNumberSet.createLottoNumbers(new int[]{4, 5, 6, 7, 8, 9})), 5),
                Arguments.of(new Lotto(LottoNumberSet.createLottoNumbers(new int[]{5, 6, 7, 8, 9, 10})), 0),
                Arguments.of(new Lotto(LottoNumberSet.createLottoNumbers(new int[]{6, 7, 8, 9, 10, 11})), 0),
                Arguments.of(new Lotto(LottoNumberSet.createLottoNumbers(new int[]{7, 8, 9, 10, 11, 12})), 0)
        );
    }

    @ParameterizedTest(name = "로또 등수를 반환한다.")
    @MethodSource(value = "provideLottoMatch")
    void match(Lotto lotto, int matchCount) {
        Lotto winner = new Lotto(LottoNumberSet.createLottoNumbers(new int[]{1, 2, 3, 4, 5, 6}));

        assertThat(lotto.rank(winner)).isEqualTo(matchCount);
    }

}