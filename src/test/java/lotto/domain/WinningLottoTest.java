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
                Arguments.of(List.of(new Lotto(List.of(
                        LottoNumber.of(1),
                        LottoNumber.of(2),
                        LottoNumber.of(3),
                        LottoNumber.of(4),
                        LottoNumber.of(5),
                        LottoNumber.of(6)))), LottoRank.FIRST),
                Arguments.of(List.of(new Lotto(List.of(
                        LottoNumber.of(1),
                        LottoNumber.of(2),
                        LottoNumber.of(3),
                        LottoNumber.of(4),
                        LottoNumber.of(5),
                        LottoNumber.of(45)))), LottoRank.SECOND),
                Arguments.of(List.of(new Lotto(List.of(
                        LottoNumber.of(1),
                        LottoNumber.of(2),
                        LottoNumber.of(3),
                        LottoNumber.of(4),
                        LottoNumber.of(5),
                        LottoNumber.of(12)))), LottoRank.THIRD),
                Arguments.of(List.of(new Lotto(List.of(
                        LottoNumber.of(1),
                        LottoNumber.of(2),
                        LottoNumber.of(3),
                        LottoNumber.of(4),
                        LottoNumber.of(11),
                        LottoNumber.of(12)))), LottoRank.FOURTH),
                Arguments.of(List.of(new Lotto(List.of(
                        LottoNumber.of(1),
                        LottoNumber.of(2),
                        LottoNumber.of(3),
                        LottoNumber.of(10),
                        LottoNumber.of(11),
                        LottoNumber.of(12)))), LottoRank.FIFTH),
                Arguments.of(List.of(new Lotto(List.of(
                        LottoNumber.of(1),
                        LottoNumber.of(2),
                        LottoNumber.of(9),
                        LottoNumber.of(10),
                        LottoNumber.of(11),
                        LottoNumber.of(12)))), LottoRank.NOT_MATCHED),
                Arguments.of(List.of(new Lotto(List.of(
                        LottoNumber.of(1),
                        LottoNumber.of(8),
                        LottoNumber.of(9),
                        LottoNumber.of(10),
                        LottoNumber.of(11),
                        LottoNumber.of(12)))), LottoRank.NOT_MATCHED),
                Arguments.of(List.of(new Lotto(List.of(
                        LottoNumber.of(7),
                        LottoNumber.of(8),
                        LottoNumber.of(9),
                        LottoNumber.of(10),
                        LottoNumber.of(11),
                        LottoNumber.of(12)))), LottoRank.NOT_MATCHED)
        );
    }

    @ParameterizedTest
    @MethodSource("로또_매개변수")
    void 당첨로또번호로_구입로또_등수를_알_수_있다(List<Lotto> lottos,
                                 LottoRank lottoRank) {
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6))), LottoNumber.of(45));

        List<LottoRank> actual = winningLotto.winningRank(new Lottos(lottos));
        List<LottoRank> expected = List.of(lottoRank);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 당첨로또번호와_보너스가_중복일_경우_예외가_발생한다() {
        assertThrows(IllegalArgumentException.class, () -> new WinningLotto(new Lotto(List.of(LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6))), LottoNumber.of(6)));
    }
}
