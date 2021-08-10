package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoWinningTest {
    @Test
    @DisplayName("로또 1등(6개 숫자 일치) 테스트")
    void 로또_1등_테스트() {
        assertThat(LottoWinning.getWinningStatus(6)).isEqualTo(LottoWinning.FIRST);
    }

    @Test
    @DisplayName("로또 2등(5개 숫자 일치) 테스트")
    void 로또_2등_테스트() {
        assertThat(LottoWinning.getWinningStatus(5)).isEqualTo(LottoWinning.SECOND);
    }

    @Test
    @DisplayName("로또 3등(4개 숫자 일치) 테스트")
    void 로또_3등_테스트() {
        assertThat(LottoWinning.getWinningStatus(4)).isEqualTo(LottoWinning.THIRD);
    }

    @Test
    @DisplayName("로또 4등(3개 숫자 일치) 테스트")
    void 로또_4등_테스트() {
        assertThat(LottoWinning.getWinningStatus(3)).isEqualTo(LottoWinning.FOURTH);
    }

    @Test
    @DisplayName("로또 0개 숫자 일치 테스트")
    void 로또_0개일치_테스트() {
        assertThat(LottoWinning.getWinningStatus(0)).isEqualTo(LottoWinning.FAIL);
    }
}
