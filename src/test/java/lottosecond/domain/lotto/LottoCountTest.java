package lottosecond.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoCountTest {

    @DisplayName("로또 구매 금액이랑 비교해서 수동 로또 개수가 더 많으면 에러가 발생합니다.")
    @Test
    void moreManualLotto() {
        // given
        // when
        // then
        assertThatThrownBy(() -> LottoCount.from(13, 12))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 개수가 총 구매 로또 수보다 클 수 없습니다.");
    }

    @DisplayName("수동 로또 개수는 0보다 작을 수 없습니다.")
    @Test
    void underZero() {
        // given
        // when
        // then
        assertThatThrownBy(() -> LottoCount.from(-1, 12))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 개수가 0보다 작을 수 없습니다.");
    }

}