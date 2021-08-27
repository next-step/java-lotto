package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class MoneyTest {

    @DisplayName("금액 정상 입력 테스트")
    @Test
    public void validMoneyTest() {
        Money money = Money.create("1000");
        assertThat(money.purchaseLottoCount()).isEqualTo(1);
    }

    @DisplayName("금액 비정상 입력 테스트")
    @Test
    public void validExceptionMoneyTest() {

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Money.create("0"))
                .withMessageMatching("금액은 1000원 이상이어야 합니다.");
    }

}