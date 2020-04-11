package lotto.domain.money;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMoneyTest {

    @DisplayName("로또 금액은 1000원 이상어야 한다.")
    @Test
    public void lottoMoneyTest() {
        assertThatThrownBy(() -> LottoMoney.of(999))
                .isInstanceOf(NotEnoughMoneyException.class)
                .hasMessageContaining("구입 금액은 1000원 이상이어야 합니다");
    }

    @DisplayName("로또 머니는 구매량을 결정할 수 있다.")
    @Test
    public void getAvailableCountTest() {
        LottoMoney lottoMoney = LottoMoney.of(1000);
        int remainCount = lottoMoney.getAvailableCount(1);

        assertThat(remainCount).isEqualTo(0);
    }
}
