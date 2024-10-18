package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoRankTest {

    @DisplayName("매칭 카운트를 전달하면 LottoRankingSystem 객체를 전달한다.")
    @Test
    void create() {
        assertThat(LottoRank.from(6)).isEqualTo(LottoRank.FIRST);
    }

    @DisplayName("랭킹 시스템 등수에 포함되지 않는 매칭 카운트를 전달하면 IllegalArgumentException 를 발생시킨다.")
    @Test
    void throw_IllegalArgumentException_when_matchingCount_is_not_() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoRank.from(2))
                .withMessage("인자 로또 번호 매칭 갯수 '2'에 적합한 등수가 없습니다.");
    }

    @DisplayName("로또 번호 일치 갯수가 로또 랭킹 시스템에 포함되지 않은 갯수라면 True를 반환한다.")
    @Test
    void return_true_when_matchingCount_is_not_included_in_rankingSystem() {
        int notRankEligible = 2;
        int rankEligible = 6;

        assertTrue(LottoRank.isNotRankEligible(notRankEligible));
        assertFalse(LottoRank.isNotRankEligible(rankEligible));
    }
}
