package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또의 매칭된 결과에 대한 타입 `LottoRank`에 대한 테스트")
class LottoRankTest {

    @DisplayName("로또 매칭 수에 따른 보너스가 없는 로또 결과 찾기")
    @ParameterizedTest
    @MethodSource("lottoRankWithoutBonusCases")
    void findLottoRankWithoutBonusTest(LottoRank lottoRankWithoutBonus) {
        // when & then
        assertThat(LottoRank.findByMatchedCountAndBonus(lottoRankWithoutBonus.matchedCount(), false))
                .isEqualTo(lottoRankWithoutBonus);
    }

    @DisplayName("로또 매칭 수에 따른 보너스가 있는 로또 결과 찾기")
    @ParameterizedTest
    @MethodSource("lottoRankWithBonusCases")
    void findLottoRankWithBonusTest(LottoRank lottoRankWithBonus) {
        // when & then
        assertThat(LottoRank.findByMatchedCountAndBonus(lottoRankWithBonus.matchedCount(), true))
                .isEqualTo(lottoRankWithBonus);
    }

    private static Stream<LottoRank> lottoRankWithoutBonusCases() {
        return Arrays.stream(LottoRank.values())
                .filter(LottoRank::hasNotBonus);
    }

    private static Stream<LottoRank> lottoRankWithBonusCases() {
        return Arrays.stream(LottoRank.values()).filter(LottoRank::hasBonus);
    }
}
