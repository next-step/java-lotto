package nextstep.lotto.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LottoRankTest {

    @Test
    @DisplayName("1등 로또")
    void lottoRank_1등_6개일치() {
        LottoRank lottoRank = LottoRank.of(6, false);
        assertThat(lottoRank).isEqualTo(LottoRank.FIRST);
    }

    @Test
    @DisplayName("2등 로또 5개일치 + 보너스")
    void lottoRank_2등_5개일치_보너스포함() {
        LottoRank lottoRank = LottoRank.of(5, true);
        assertThat(lottoRank).isEqualTo(LottoRank.SECOND);
    }

    @Test
    @DisplayName("3등로또 5개일치")
    void lottoRank_3등_5개일치() {
        LottoRank lottoRank = LottoRank.of(5, false);
        assertThat(lottoRank).isEqualTo(LottoRank.THIRD);
    }

    @Test
    @DisplayName("4등 4개일치")
    void lottoRank_4등_4개일치() {
        LottoRank lottoRank = LottoRank.of(4, false);
        assertThat(lottoRank).isEqualTo(LottoRank.FOURTH);
    }

    @Test
    @DisplayName("5등_3개일치")
    void lottoRank_5등_3개일치() {
        LottoRank lottoRank = LottoRank.of(3, false);
        assertThat(lottoRank).isEqualTo(LottoRank.FIFTH);
    }

    @Test
    @DisplayName("꽝_2개일치")
    void lottoRank_꽝_2개일치() {
        LottoRank lottoRank = LottoRank.of(2, false);
        assertThat(lottoRank).isEqualTo(LottoRank.MISS);
    }

    @Test
    @DisplayName("꽝_1개일치")
    void lottoRank_꽝_1개일치() {
        LottoRank lottoRank = LottoRank.of(1, false);
        assertThat(lottoRank).isEqualTo(LottoRank.MISS);
    }

    @Test
    @DisplayName("꽝_0개일치")
    void lottoRank_꽝_0개일치() {
        LottoRank lottoRank = LottoRank.of(0, false);
        assertThat(lottoRank).isEqualTo(LottoRank.MISS);
    }

}
