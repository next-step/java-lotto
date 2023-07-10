package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningLottoTest {

    private static Stream<Arguments> generateData() {

        return Stream.of(
            Arguments.of(Lotto.createSpecificLotto(List.of(1, 2, 3, 4, 5, 6)), LottoRank.FIRST),
            Arguments.of(Lotto.createSpecificLotto(List.of(1, 2, 3, 4, 5, 7)), LottoRank.SECOND),
            Arguments.of(Lotto.createSpecificLotto(List.of(1, 2, 3, 4, 5, 8)), LottoRank.THIRD),
            Arguments.of(Lotto.createSpecificLotto(List.of(1, 2, 3, 4, 8, 9)), LottoRank.FOURTH),
            Arguments.of(Lotto.createSpecificLotto(List.of(1, 2, 3, 8, 9, 10)), LottoRank.FIFTH),
            Arguments.of(Lotto.createSpecificLotto(List.of(1, 2, 8, 9, 10, 11)), LottoRank.NONE)
        );
    }

    @Test
    @DisplayName("6개의 일반 번호와 1개의 보너스 번호로 이루어진다.")
    void containsSixNumbersAndOneBonusNumberTest() {
        //given
        Lotto lotto = Lotto.createSpecificLotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(lotto, new LottoNumber(7));

        //when, then
        assertThat(winningLotto.getLottoNumbers().getLottoNumbers()).hasSize(6);
        assertThat(winningLotto.getBonus()).isInstanceOf(LottoNumber.class);
    }

    @ParameterizedTest
    @MethodSource("generateData")
    @DisplayName("1등부터 미당첨까지 등수 확인하는 테스트")
    void getRankTest(Lotto test, LottoRank rank) {
        //given
        Lotto lotto = Lotto.createSpecificLotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(lotto, new LottoNumber(7));

        //then
        assertThat(winningLotto.calculateRank(test)).isEqualTo(rank);
    }
}
