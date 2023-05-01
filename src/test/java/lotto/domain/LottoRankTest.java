package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoRankTest {

    @Test
    @DisplayName("로또번호 3개 매칭부터 의미있는 값이기 때문에 그 이하는 어떤 값을 입력해도 NONE을 반환합니다.")
    void test01() {
        assertAll(
                () -> assertThat(LottoRank.findLottoRank(-10, false)).isSameAs(LottoRank.NONE),
                () -> assertThat(LottoRank.findLottoRank(-1, true)).isSameAs(LottoRank.NONE),
                () -> assertThat(LottoRank.findLottoRank(0, false)).isSameAs(LottoRank.NONE),
                () -> assertThat(LottoRank.findLottoRank(0, true)).isSameAs(LottoRank.NONE),
                () -> assertThat(LottoRank.findLottoRank(1, false)).isSameAs(LottoRank.NONE),
                () -> assertThat(LottoRank.findLottoRank(1, true)).isSameAs(LottoRank.NONE),
                () -> assertThat(LottoRank.findLottoRank(2, false)).isSameAs(LottoRank.NONE),
                () -> assertThat(LottoRank.findLottoRank(2, true)).isSameAs(LottoRank.NONE)
        );
    }

    @Test
    @DisplayName("로또번호 3개 매칭부터 의미있는 값으로 조건 입력시 해당되는 값을 가져옵니다.")
    void test02() {
        assertAll(
                () -> assertThat(LottoRank.findLottoRank(3, false)).isSameAs(LottoRank.FIFTH),
                () -> assertThat(LottoRank.findLottoRank(4, false)).isSameAs(LottoRank.FOURTH),
                () -> assertThat(LottoRank.findLottoRank(5, false)).isSameAs(LottoRank.THIRD),
                () -> assertThat(LottoRank.findLottoRank(5, true)).isSameAs(LottoRank.SECOND),
                () -> assertThat(LottoRank.findLottoRank(6, false)).isSameAs(LottoRank.FIRST)
        );
    }

    @Test
    @DisplayName("의미있는 값 중 로또번호 5개 매칭시에만 isMatchedBonusBall 구분이 있습니다.")
    void test03() {
        assertAll(
                () -> assertThat(LottoRank.findLottoRank(3, true)).isSameAs(LottoRank.FIFTH),
                () -> assertThat(LottoRank.findLottoRank(4, true)).isSameAs(LottoRank.FOURTH),
                () -> assertThat(LottoRank.findLottoRank(5, false)).isSameAs(LottoRank.THIRD),
                () -> assertThat(LottoRank.findLottoRank(5, true)).isSameAs(LottoRank.SECOND),
                () -> assertThat(LottoRank.findLottoRank(6, true)).isSameAs(LottoRank.FIRST)
        );
    }
    
}