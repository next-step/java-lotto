package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningLottoTest {

    @ParameterizedTest
    @MethodSource("lottoNumbers")
    void 해당_로또가_몇_등인지_계산할_수_있다(List<Integer> lottoInput, Ranking ranking) {
        final List<LottoNumber> winningNumber = Arrays.asList(1, 2, 3, 4, 5, 6).stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList());

        final LottoNumber bonusBall = new LottoNumber(8);

        final WinningLotto winningLotto = new WinningLotto(Lotto.from(winningNumber), bonusBall);

        final List<LottoNumber> lottoNumbers = lottoInput.stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList());

        final Lotto lotto = Lotto.from(lottoNumbers);

        assertThat(winningLotto.matchLotto(lotto)).isEqualTo(ranking);
    }

    private static Stream<Arguments> lottoNumbers() {
        return Stream.of(
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), Ranking.FIRST),
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 8), Ranking.SECOND),
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 7), Ranking.THIRD),
            Arguments.of(Arrays.asList(1, 2, 3, 4, 7, 9), Ranking.FOURTH),
            Arguments.of(Arrays.asList(1, 2, 3, 7, 9, 10), Ranking.FIFTH),
            Arguments.of(Arrays.asList(7, 9, 10, 11, 12, 13), Ranking.FAIL)
        );
    }

}
