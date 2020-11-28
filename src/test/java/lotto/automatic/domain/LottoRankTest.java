package lotto.automatic.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {

    @Test
    @DisplayName("1등 테스트")
    public void FIRST_RANK_TEST() {
        LottoRank one = LottoRank.matchCount(6);
        assertThat(one.earningMoney).isEqualTo(200000000);
    }

    @Test
    @DisplayName("2등 테스트")
    public void SECOND_RANK_TEST() {
        LottoRank two = LottoRank.matchCount(5);
        assertThat(two.earningMoney).isEqualTo(1500000);
    }

    @Test
    @DisplayName("3등 테스트")
    public void THIRD_RANK_TEST() {
        LottoRank three = LottoRank.matchCount(4);
        assertThat(three.earningMoney).isEqualTo(50000);
    }

    @Test
    @DisplayName("4등 테스트")
    public void FORTH_RANK_TEST() {
        LottoRank four = LottoRank.matchCount(3);
        assertThat(four.earningMoney).isEqualTo(5000);
    }

    @Test
    @DisplayName("매칭 카운트 2 꽝 테스트")
    public void NONE_RANK_OF_MATCH_COUNT_2_TEST() {
        LottoRank none = LottoRank.matchCount(2);
        assertThat(none.earningMoney).isEqualTo(0);
    }

    @Test
    @DisplayName("매칭 카운트 1 꽝 테스트")
    public void NONE_RANK_OF_MATCH_COUNT_1_TEST() {
        LottoRank none = LottoRank.matchCount(1);
        assertThat(none.earningMoney).isEqualTo(0);
    }

    @Test
    @DisplayName("매칭 카운트 0 꽝 테스트")
    public void NONE_RANK_OF_MATCH_COUNT_0_TEST() {
        LottoRank none = LottoRank.matchCount(0);
        assertThat(none.earningMoney).isEqualTo(0);
    }

}