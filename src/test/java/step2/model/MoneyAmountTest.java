package step2.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step2.exception.NotEnoughMoneyException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyAmountTest {

    @DisplayName("정적 생성자는 MoneyAmount 인스턴스 반환")
    @ValueSource(ints = {0, 1000, 2000, 3000})
    @ParameterizedTest
    void create(int amount) {
        Money money = Money.valueOf(amount);
        MoneyAmount moneyAmount = MoneyAmount.create(money);

        assertThat(moneyAmount).isInstanceOf(MoneyAmount.class);
        assertThat(moneyAmount.getRemainAmount()).isEqualTo(money);
    }

    @DisplayName("사용한 금액이 없으면 보유 금액은 입력한 금액과 동일")
    @Test
    void useAmount() {
        MoneyAmount moneyAmount = LottoData.createMoneyAmount(1_000);
        moneyAmount.useAmount(Money.valueOf(1000));

        assertThat(moneyAmount.getUsedAmount()).isEqualTo(Money.valueOf(1_000));
    }

    @DisplayName("사용 금액이 보유 금액보다 클 경우 예외 발생")
    @Test
    void useAmountExceptionThrown() {
        assertThatThrownBy(() -> LottoData.createMoneyAmount(999).useAmount(Money.valueOf(1000)))
                .isInstanceOf(NotEnoughMoneyException.class);
    }
}
