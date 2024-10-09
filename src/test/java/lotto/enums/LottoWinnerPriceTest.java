package lotto.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoWinnerPriceTest {

    @Test
    @DisplayName("여섯개가 맞으면 1등 상금을 반환한다.")
    void 일등_상금_반환() {
        assertThat(LottoWinnerPrice.getPrice(6)).isEqualTo(2000000000);
    }

    @Test
    @DisplayName("다섯개가 맞으면 2등 상금을 반환한다.")
    void 이등_상금_반환() {
        assertThat(LottoWinnerPrice.getPrice(5)).isEqualTo(1500000);
    }

    @Test
    @DisplayName("네개가 맞으면 3등 상금을 반환한다.")
    void 삼등_상금_반환() {
        assertThat(LottoWinnerPrice.getPrice(4)).isEqualTo(50000);
    }

    @Test
    @DisplayName("세개가 맞으면 4등 상금을 반환한다.")
    void 사등_상금_반환() {
        assertThat(LottoWinnerPrice.getPrice(3)).isEqualTo(5000);
    }

    @Test
    @DisplayName("list 조회를 하면 등록된 상의 개수만큼 반환한다.")
    void enum_개수_반환() {
        assertThat(LottoWinnerPrice.getLottoWinnerPrice()).hasSize(4);
    }
}