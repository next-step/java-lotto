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
                Arguments.of(List.of("1, 2, 3, 4, 5, 6"), LottoRank.FIRST),
                Arguments.of(List.of("1, 2, 3, 4, 5, 45"), LottoRank.SECOND),
                Arguments.of(List.of("1, 2, 3, 4, 5, 12"), LottoRank.THIRD),
                Arguments.of(List.of("1, 2, 3, 4, 11, 12"), LottoRank.FOURTH),
                Arguments.of(List.of("1, 2, 3, 10, 11, 12"), LottoRank.FIFTH),
                Arguments.of(List.of("1, 2, 9, 10, 11, 12"), LottoRank.NOT_MATCHED),
                Arguments.of(List.of("1, 8, 9, 10, 11, 12"), LottoRank.NOT_MATCHED),
                Arguments.of(List.of("7, 8, 9, 10, 11, 12"), LottoRank.NOT_MATCHED)
        );
    }

    @ParameterizedTest
    @MethodSource("로또_매개변수")
    void 당첨로또번호로_구입로또_등수를_알_수_있다(List<String> lotto,
                                 LottoRank lottoRank) {
        WinningLotto winningLotto = new WinningLotto(List.of(new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)), 45);

        List<LottoRank> actual = winningLotto.winningRank(new Lottos(lotto));
        List<LottoRank> expected = List.of(lottoRank);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 당첨로또번호와_보너스가_중복일_경우_예외가_발생한다() {
        assertThrows(IllegalArgumentException.class, () -> new WinningLotto(List.of(new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)), 1));
    }
}
