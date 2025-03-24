package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

class LottoResultTest {

    @ParameterizedTest
    @MethodSource("provideWinningLottoAndLottoStatistics")
    void testWinningLottoAndLottoStatistics(Lotto winningLotto, Lotto lotto, LottoResult expectedLottoResult) {
        LottoResult lottoResult = LottoResult.getResult(winningLotto, lotto);
        Assertions.assertThat(lottoResult).isEqualTo(expectedLottoResult);
    }

    static Arguments[] provideWinningLottoAndLottoStatistics() {
        return new Arguments[] {
                Arguments.of(Lotto.create(List.of(1, 2, 3, 4, 5, 6)), Lotto.create(List.of(1, 2, 3, 4, 5, 6)), LottoResult.FIRST),
                Arguments.of(Lotto.create(List.of(1, 2, 3, 4, 5, 6)), Lotto.create(List.of(1, 2, 3, 4, 5, 16)), LottoResult.SECOND),
                Arguments.of(Lotto.create(List.of(1, 2, 3, 4, 5, 6)), Lotto.create(List.of(1, 2, 3, 4, 15, 16)), LottoResult.THIRD),
                Arguments.of(Lotto.create(List.of(1, 2, 3, 4, 5, 6)), Lotto.create(List.of(1, 2, 3, 14, 15, 16)), LottoResult.FOURTH),
                Arguments.of(Lotto.create(List.of(1, 2, 3, 4, 5, 6)), Lotto.create(List.of(1, 2, 13, 14, 15, 16)), LottoResult.NONE),
                Arguments.of(Lotto.create(List.of(1, 2, 3, 4, 5, 6)), Lotto.create(List.of(1, 12, 13, 14, 15, 16)), LottoResult.NONE)
        };
    }
}
