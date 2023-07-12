package lotto.model.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LottosTest {
    @Test
    void 로또_컬렉션_객체_생성() {
        // given, when, then
        assertDoesNotThrow(() -> new Lottos(0, null));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5})
    void 로또_컬렉션_개수_입력시_해당_개수의_로또_객체들_생성(int size) {
        // given
        NumbersGenerator numberGenerator = new FixedNumbersGenerator(List.of(1, 2, 3, 4, 5, 6));

        // when
        Lottos lottos = new Lottos(size, numberGenerator);

        // then
        assertThat(lottos.getLottos()).hasSize(size);
    }

    @Test
    void 로또_컬렉션_숫자_생성기_주입시_해당_숫자들로_로또생성_성공() {
        // given
        int size = 10;
        NumbersGenerator numberGenerator = new FixedNumbersGenerator(List.of(1, 2, 3, 4, 5, 6));

        // when
        Lottos lottos = new Lottos(size, numberGenerator);

        // then
        assertThat(lottos.getLottos().get(0)).isEqualTo(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
    }

    @ParameterizedTest
    @MethodSource("당첨_번호와_보너스_볼로_로또들의_당첨_결과_계산_테스트케이스")
    void 당첨_번호와_보너스_볼로_로또들의_당첨_결과_계산_성공(List<Integer> generatedNumbers, Rank expectedRank) {
        // given
        final WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);
        final Lottos lottos = new Lottos(2, new FixedNumbersGenerator(generatedNumbers));

        // when
        List<Rank> lottoResult = lottos.matchWinningNumbers(winningNumbers);

        // then
        assertThat(lottoResult.stream().filter(rank -> rank.equals(expectedRank)).count()).isEqualTo(2);
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
