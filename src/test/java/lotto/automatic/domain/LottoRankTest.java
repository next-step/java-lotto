package lotto.automatic.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {

    @Test
    @DisplayName("1등 테스트")
    public void FIRST_RANK_TEST() {
        LottoRank one = LottoRank.match(6, false);
        assertThat(one.getEarningMoney()).isEqualTo(200000000);
    }

    @Test
    @DisplayName("2등 테스트")
    public void SECOND_RANK_TEST() {
        LottoRank two = LottoRank.match(5, true);
        assertThat(two.getEarningMoney()).isEqualTo(30000000);
    }

    @Test
    @DisplayName("3등 테스트")
    public void THIRD_RANK_TEST() {
        LottoRank three = LottoRank.match(4, true);
        assertThat(three.getEarningMoney()).isEqualTo(50000);
    }

    @Test
    @DisplayName("4등 테스트")
    public void FORTH_RANK_TEST() {
        LottoRank four = LottoRank.match(3, true);
        assertThat(four.getEarningMoney()).isEqualTo(5000);
    }

    @Test
    @DisplayName("매칭 카운트 2 꽝 테스트")
    public void NONE_RANK_OF_MATCH_COUNT_2_TEST() {
        LottoRank none = LottoRank.match(2, true);
        assertThat(none.getEarningMoney()).isEqualTo(0);
    }

    @Test
    @DisplayName("매칭 카운트 1 꽝 테스트")
    public void NONE_RANK_OF_MATCH_COUNT_1_TEST() {
        LottoRank none = LottoRank.match(1, true);
        assertThat(none.getEarningMoney()).isEqualTo(0);
    }

    @Test
    @DisplayName("매칭 카운트 0 꽝 테스트")
    public void NONE_RANK_OF_MATCH_COUNT_0_TEST() {
        LottoRank none = LottoRank.match(0, true);
        assertThat(none.getEarningMoney()).isEqualTo(0);
    }

}