package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {

    public static final Money MONEY = new Money();

    @Test
    @DisplayName("구입 금액이 로또 금액인 1000원 보다 낮을 시 에러를 반환하는지 확인")
    void lottoMoneyThrowsExceptionWhenNotEnough() {
        assertThatThrownBy(() -> MONEY.calculateLottoAmount(500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("금액이 부족합니다.");
    }

    @Test
    @DisplayName("구입 금액을 통해 정확한 로또 구매 개수를 계산하는지 확인")
    public void getLottoAmount() {
        Money userMoney = new Money();
        int amount = userMoney.calculateLottoAmount(10000);
        assertThat(amount).isEqualTo(10);
    }

}
