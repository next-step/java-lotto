package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

class WinningLottoTest {

    @ParameterizedTest
    @MethodSource("provideWinningLottoAndLottoStatistics")
    void testWinningLottoAndLottoStatistics(WinningLotto winningLotto, Lotto lotto, LottoResult expectedLottoResult) {
        LottoResult lottoResult = winningLotto.getResult(lotto);
        Assertions.assertThat(lottoResult).isEqualTo(expectedLottoResult);
    }

    static Arguments[] provideWinningLottoAndLottoStatistics() {
        return new Arguments[] {
                Arguments.of(WinningLotto.of(Lotto.create(List.of(1, 2, 3, 4, 5, 6)), LottoNumber.of(6)), Lotto.create(List.of(1, 2, 3, 4, 5, 6)), LottoResult.FIRST),
                Arguments.of(WinningLotto.of(Lotto.create(List.of(1, 2, 3, 4, 5, 6)), LottoNumber.of(45)), Lotto.create(List.of(1, 2, 3, 4, 5, 6)), LottoResult.FIRST),
                Arguments.of(WinningLotto.of(Lotto.create(List.of(1, 2, 3, 4, 5, 6)), LottoNumber.of(16)), Lotto.create(List.of(1, 2, 3, 4, 5, 16)), LottoResult.SECOND),
                Arguments.of(WinningLotto.of(Lotto.create(List.of(1, 2, 3, 4, 5, 6)), LottoNumber.of(45)), Lotto.create(List.of(1, 2, 3, 4, 5, 16)), LottoResult.THIRD),
                Arguments.of(WinningLotto.of(Lotto.create(List.of(1, 2, 3, 4, 5, 6)), LottoNumber.of(16)), Lotto.create(List.of(1, 2, 3, 4, 15, 16)), LottoResult.FOURTH),
                Arguments.of(WinningLotto.of(Lotto.create(List.of(1, 2, 3, 4, 5, 6)), LottoNumber.of(45)), Lotto.create(List.of(1, 2, 3, 4, 15, 16)), LottoResult.FOURTH),
                Arguments.of(WinningLotto.of(Lotto.create(List.of(1, 2, 3, 4, 5, 6)), LottoNumber.of(16)), Lotto.create(List.of(1, 2, 3, 14, 15, 16)), LottoResult.FIFTH),
                Arguments.of(WinningLotto.of(Lotto.create(List.of(1, 2, 3, 4, 5, 6)), LottoNumber.of(45)), Lotto.create(List.of(1, 2, 3, 14, 15, 16)), LottoResult.FIFTH),
                Arguments.of(WinningLotto.of(Lotto.create(List.of(1, 2, 3, 4, 5, 6)), LottoNumber.of(16)), Lotto.create(List.of(1, 2, 13, 14, 15, 16)), LottoResult.NONE),
                Arguments.of(WinningLotto.of(Lotto.create(List.of(1, 2, 3, 4, 5, 6)), LottoNumber.of(45)), Lotto.create(List.of(1, 12, 13, 14, 15, 16)), LottoResult.NONE)
        };
    }
}
