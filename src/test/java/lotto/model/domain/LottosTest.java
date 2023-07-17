package lotto.model.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class LottosTest {

    @Test
    void 로또_컬렉션_객체_생성() {
        assertThatNoException()
                .isThrownBy(() -> Lottos.create(List.of(List.of(1, 2, 3, 4, 5, 6)), 0));
    }

    @Test
    void 로또_컬렉션_개수_입력시_해당_개수의_로또_객체들_생성() {
        // given
        final NumbersGenerator numberGenerator = new FixedNumbersGenerator(List.of(1, 2, 3, 4, 5, 6));
        final List<List<Integer>> manualLottos = List.of(numberGenerator.generate());

        // when
        final Lottos lottos = Lottos.create(manualLottos, 0);

        // then
        assertThat(lottos.getLottos()).hasSize(1);
    }

    @ParameterizedTest
    @MethodSource("당첨_번호와_보너스_볼로_로또들의_당첨_결과_계산_테스트케이스")
    void 당첨_번호와_보너스_볼로_로또들의_당첨_결과_계산_성공(List<Integer> generatedNumbers, Rank expectedRank) {
        // given
        final Lotto lotto = Lotto.create(List.of(1, 2, 3, 4, 5, 6));
        final WinningLotto winningLotto = WinningLotto.of(lotto, LottoNumber.of(7));
        final Lottos lottos = Lottos.create(List.of(generatedNumbers), 0);

        // when
        final List<Rank> lottoResult = lottos.matchWinningNumbers(winningLotto);

        // then
        assertThat(lottoResult.stream().filter(rank -> rank.equals(expectedRank)).count())
                .isEqualTo(1);
    }

    static Stream<Arguments> 당첨_번호와_보너스_볼로_로또들의_당첨_결과_계산_테스트케이스() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), Rank.FIRST),
                Arguments.of(List.of(1, 2, 3, 4, 5, 7), Rank.SECOND),
                Arguments.of(List.of(1, 2, 3, 4, 5, 8), Rank.THIRD),
                Arguments.of(List.of(1, 2, 3, 4, 7, 8), Rank.FOURTH),
                Arguments.of(List.of(1, 2, 3, 7, 8, 9), Rank.FIFTH),
                Arguments.of(List.of(1, 2, 7, 8, 9, 10), Rank.NONE),
                Arguments.of(List.of(1, 7, 8, 9, 10, 11), Rank.NONE),
                Arguments.of(List.of(7, 8, 9, 10, 11, 12), Rank.NONE)
        );
    }
}
