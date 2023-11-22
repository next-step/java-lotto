package lottosecond.domain.lotto;

import lottosecond.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ManualLottoCountTest {

    @DisplayName("로또 구매 금액이랑 비교해서 수동 로또 개수가 더 많으면 에러가 발생합니다.")
    @Test
    void moreManualLotto() {
        // given
        Money lottoBuyMoney = new Money(12000);
        // when
        // then
        assertThatThrownBy(() -> ManualLottoCount.from(13, lottoBuyMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("수동 로또 개수가 총 구매 로또 수보다 클 수 없습니다.");
    }

    @DisplayName("수동 로또 개수는 0보다 작을 수 없습니다.")
    @Test
    void underZero() {
        // given
        Money lottoBuyMoney = new Money(12000);
        // when
        // then
        assertThatThrownBy(() -> ManualLottoCount.from(-1, lottoBuyMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("수동 로또 개수가 0보다 작을 수 없습니다.");
    }
}