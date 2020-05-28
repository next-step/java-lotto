package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticUtilTest {

    @DisplayName("Prize에 해당하는 Lotto 개수가 반환")
    @ParameterizedTest
    @MethodSource("source_award_inRank_shouldSucceed")
    public void getPrizeCount_shouldSucceed(Prize prize, Lotto winLotto, List<Lotto> lottoList, int expected) {
        int result = LottoStatisticUtil.getPrizeCount(prize, winLotto, lottoList);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> source_award_inRank_shouldSucceed() {
        Lotto winLotto = LottoFixtures.win();
        List<Lotto> lottoList = Arrays.asList(LottoFixtures.unrank(), LottoFixtures.three(), LottoFixtures.three(),
                LottoFixtures.four(), LottoFixtures.five(), LottoFixtures.six(), LottoFixtures.six());

        return Stream.of(
                Arguments.of(Prize.UNRANKED, winLotto, lottoList, 1),
                Arguments.of(Prize.COINCIDE_THREE, winLotto, lottoList, 2),
                Arguments.of(Prize.COINCIDE_FOUR, winLotto, lottoList, 1),
                Arguments.of(Prize.COINCIDE_FIVE, winLotto, lottoList, 1),
                Arguments.of(Prize.COINCIDE_SIX, winLotto, lottoList, 2));
    }
}
