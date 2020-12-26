package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {

    @Test
    @DisplayName("일반 Rank가 나오는 테스트")
    void general() {
        LottoRank lottoRank = LottoRank.valueOf(6, true);
        assertThat(lottoRank).isEqualTo(LottoRank.FIRST);
        lottoRank = LottoRank.valueOf(4, true);
        assertThat(lottoRank).isEqualTo(LottoRank.FOURTH);
        lottoRank = LottoRank.valueOf(3, true);
        assertThat(lottoRank).isEqualTo(LottoRank.FIFTH);

        lottoRank = LottoRank.valueOf(6, false);
        assertThat(lottoRank).isEqualTo(LottoRank.FIRST);
        lottoRank = LottoRank.valueOf(4, false);
        assertThat(lottoRank).isEqualTo(LottoRank.FOURTH);
        lottoRank = LottoRank.valueOf(3, false);
        assertThat(lottoRank).isEqualTo(LottoRank.FIFTH);
    }

    @Test
    @DisplayName("5개 일치, 보너스볼 일치 인 경우 2등")
    void matchBonus() {
        LottoRank lottoRank = LottoRank.valueOf(5, true);
        assertThat(lottoRank).isEqualTo(LottoRank.SECOND);
    }

    @Test
    @DisplayName("5개 일치, 보너스볼 불일치인 경우 3등")
    void matchNotBonus() {
        LottoRank lottoRank = LottoRank.valueOf(5, false);
        assertThat(lottoRank).isEqualTo(LottoRank.THIRD);
    }

    @Test
    @DisplayName("일정 개수 이하로 맞으면 MISS 가 나온다")
    void miss() {
        LottoRank lottoRank = LottoRank.valueOf(2, true);
        assertThat(lottoRank).isEqualTo(LottoRank.MISS);
        lottoRank = LottoRank.valueOf(1, true);
        assertThat(lottoRank).isEqualTo(LottoRank.MISS);
        lottoRank = LottoRank.valueOf(0, true);
        assertThat(lottoRank).isEqualTo(LottoRank.MISS);

        lottoRank = LottoRank.valueOf(2, false);
        assertThat(lottoRank).isEqualTo(LottoRank.MISS);
        lottoRank = LottoRank.valueOf(1, false);
        assertThat(lottoRank).isEqualTo(LottoRank.MISS);
        lottoRank = LottoRank.valueOf(0, false);
        assertThat(lottoRank).isEqualTo(LottoRank.MISS);
    }

}