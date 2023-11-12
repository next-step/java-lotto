package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WinningLottoTest {

    static Stream<Arguments> 로또_매개변수() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), LottoRank.FIRST),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 45)), LottoRank.SECOND),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 12)), LottoRank.THIRD),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 11, 12)), LottoRank.FOURTH),
                Arguments.of(new Lotto(List.of(1, 2, 3, 9, 11, 12)), LottoRank.FIFTH),
                Arguments.of(new Lotto(List.of(1, 2, 9, 10, 11, 12)), LottoRank.NOT_MATCHED),
                Arguments.of(new Lotto(List.of(1, 8, 9, 10, 11, 12)), LottoRank.NOT_MATCHED),
                Arguments.of(new Lotto(List.of(7, 8, 9, 10, 11, 12)), LottoRank.NOT_MATCHED)
                // 다른 테스트 케이스도 추가할 수 있습니다.
        );
    }

    @ParameterizedTest
    @MethodSource("로또_매개변수")
    void 당첨로또번호로_구입로또_등수를_알_수_있다(Lotto lotto,
                                 LottoRank lottoRank) {
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 45);

        List<LottoRank> actual = winningLotto.winningRank(List.of(lotto));
        List<LottoRank> expected = List.of(lottoRank);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 당첨로또번호와_보너스가_중복일_경우_예외가_발생한다() {
        assertThrows(IllegalArgumentException.class, () -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 1));
    }
}
