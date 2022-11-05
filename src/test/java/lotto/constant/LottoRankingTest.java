package lotto.constant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankingTest {
    @Test
    @DisplayName("당첨번호 6개 1등 확인")
    void 로또_1등(){
        assertThat(LottoRanking.of(6, false)).isEqualTo(LottoRanking.FIRST);
    }

    @Test
    @DisplayName("당첨번호 5개 보너스번호 당첨, 2등 확인")
    void 로또_2등(){
        assertThat(LottoRanking.of(5, true)).isEqualTo(LottoRanking.SECOND);
    }

    @Test
    @DisplayName("당첨번호 5개 3등 확인")
    void 로또_3등(){
        assertThat(LottoRanking.of(5, false)).isEqualTo(LottoRanking.THIRD);
    }

    @Test
    @DisplayName("당첨번호 4개 4등 확인")
    void 로또_4등(){
        assertThat(LottoRanking.of(4, false)).isEqualTo(LottoRanking.FOURTH);
    }

    @Test
    @DisplayName("당첨번호 3개 5등 확인")
    void 로또_5등(){
        assertThat(LottoRanking.of(3, false)).isEqualTo(LottoRanking.FIFTH);
    }

    @Test
    @DisplayName("등수 해당사항이 없으면 0인지 확인")
    void 로또_MISS(){
        assertThat(LottoRanking.of(7, false)).isEqualTo(LottoRanking.MISS);
        assertThat(LottoRanking.of(2, false)).isEqualTo(LottoRanking.MISS);
        assertThat(LottoRanking.of(0, false)).isEqualTo(LottoRanking.MISS);
    }

    @Test
    @DisplayName("로또 당첨 금액 계산하기")
    void 로또_보상_계산(){
        LottoRanking lottoRanking = LottoRanking.FIFTH;
        assertThat(lottoRanking.calculateAward(3)).isEqualTo(15000);
    }
}