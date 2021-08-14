package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    @Test
    @DisplayName("로또 1등(6개 숫자 일치) 테스트")
    void 로또_1등_테스트() {
        assertThat(LottoResult.getLottoResult(6, false)).isEqualTo(LottoResult.FIRST);
    }

    @Test
    @DisplayName("로또 2등(5개 숫자, 보너스번호 일치) 테스트")
    void 로또_2등_테스트() {
        assertThat(LottoResult.getLottoResult(5, true)).isEqualTo(LottoResult.SECOND);
    }

    @Test
    @DisplayName("로또 3등(5개 숫자 일치) 테스트")
    void 로또_3등_테스트() {
        assertThat(LottoResult.getLottoResult(5, false)).isEqualTo(LottoResult.THIRD);
    }

    @Test
    @DisplayName("로또 4등(4개 숫자 일치) 테스트")
    void 로또_4등_테스트() {
        assertThat(LottoResult.getLottoResult(4, false)).isEqualTo(LottoResult.FOURTH);
    }

    @Test
    @DisplayName("로또 5등(3개 숫자 일치) 테스트")
    void 로또_5등_테스트() {
        assertThat(LottoResult.getLottoResult(3, false)).isEqualTo(LottoResult.FIFTH);
    }

    @Test
    @DisplayName("로또 0개 숫자 일치 테스트")
    void 로또_0개_일치_테스트() {
        assertThat(LottoResult.getLottoResult(0, false)).isEqualTo(LottoResult.FAIL);
    }

    @Test
    @DisplayName("로또 2개 숫자 일치 테스트")
    void 로또_2개_일치_테스트() {
        assertThat(LottoResult.getLottoResult(2, true)).isEqualTo(LottoResult.FAIL);
    }

}
