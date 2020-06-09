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
    public void getPrizeCount_shouldSucceed(Prize prize, Lotto winLotto, int bonusNumber, List<Lotto> lottoList, int expected) {
        int result = LottoStatisticUtil.getPrizeCount(prize, winLotto, bonusNumber, Lottos.of(lottoList));
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> source_award_inRank_shouldSucceed() {
        Lotto winLotto = LottoFixtures.win();
        List<Lotto> lottoList = Arrays.asList(LottoFixtures.unrank(), LottoFixtures.three(), LottoFixtures.three(),
                LottoFixtures.four(), LottoFixtures.five(), LottoFixtures.six(), LottoFixtures.six());

        return Stream.of(
                Arguments.of(Prize.UNRANKED, winLotto, LottoFixtures.unmatchedBonusNumber(), lottoList, 1),
                Arguments.of(Prize.FIFTH, winLotto, LottoFixtures.unmatchedBonusNumber(), lottoList, 2),
                Arguments.of(Prize.FOURTH, winLotto, LottoFixtures.unmatchedBonusNumber(), lottoList, 1),
                Arguments.of(Prize.THIRD, winLotto, LottoFixtures.unmatchedBonusNumber(), lottoList, 1),
                Arguments.of(Prize.SECOND, winLotto, LottoFixtures.matchedBonusNumber(), lottoList, 1),
                Arguments.of(Prize.FIRST, winLotto, LottoFixtures.unmatchedBonusNumber(), lottoList, 2));
    }

    @DisplayName("Prize 분포에 따른 수익률이 반환")
    @ParameterizedTest
    @MethodSource("source_getYield_shouldSucceed")
    public void getYield_shouldSucceed(Price totalPrice, Lotto winLotto, int bonusNumber, List<Lotto> lottoList, double expected) {
        double result = LottoStatisticUtil.getYield(totalPrice, winLotto, bonusNumber, Lottos.of(lottoList));
        assertThat(Math.abs(result - expected) < 0.01).isEqualTo(true);
    }

    private static Stream<Arguments> source_getYield_shouldSucceed() {
        Lotto winLotto = LottoFixtures.win();
        List<Lotto> lottoList = Arrays.asList(LottoFixtures.unrank(), LottoFixtures.three(), LottoFixtures.three(),
                LottoFixtures.four(), LottoFixtures.five(), LottoFixtures.six(), LottoFixtures.six());

        return Stream.of(
                Arguments.of(Price.of("7000"), winLotto, LottoFixtures.unmatchedBonusNumber(), lottoList, 571651.4285714285f));
    }
}
