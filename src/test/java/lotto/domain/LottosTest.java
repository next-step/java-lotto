package lotto.domain;

import lotto.strategy.TestLottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @ParameterizedTest
    @MethodSource("provideLottoRankGenerateCondition")
    @DisplayName("성공 - 로또의 당첨 결과를 구한다.")
    void success_lotto_match_count(
            List<Integer> lottoNumbers,
            List<Integer> lottoWinNumbers,
            int bonusBall,
            LottoRank expectLottoRank
    ) {
        Lottos lottos = new Lottos(List.of(new Lotto(new LottoNumbers(new TestLottoGenerator(lottoNumbers)))));
        List<LottoRank> lottoRank = lottos.matchCount(new LottoWinNumbers(lottoWinNumbers), new BonusBall(bonusBall));

        assertThat(lottoRank).containsOnlyOnce(expectLottoRank);
    }

    private static Stream<Arguments> provideLottoRankGenerateCondition() {
        return Stream.of(
                Arguments.of(
                        List.of(1, 2, 3, 7, 8, 9),
                        List.of(1, 2, 3, 4, 5, 6),
                        40,
                        LottoRank.FIFTH
                ),
                Arguments.of(
                        List.of(1, 2, 3, 4, 8, 9),
                        List.of(1, 2, 3, 4, 5, 6),
                        40,
                        LottoRank.FOURTH
                ),
                Arguments.of(
                        List.of(1, 2, 3, 4, 5, 9),
                        List.of(1, 2, 3, 4, 5, 6),
                        40,
                        LottoRank.THIRD
                ),
                Arguments.of(
                        List.of(1, 2, 3, 4, 5, 40),
                        List.of(1, 2, 3, 4, 5, 6),
                        40,
                        LottoRank.SECOND
                ),
                Arguments.of(
                        List.of(1, 2, 3, 4, 5, 6),
                        List.of(1, 2, 3, 4, 5, 6),
                        40,
                        LottoRank.FIRST
                )
        );
    }

}