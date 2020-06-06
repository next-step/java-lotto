package step2.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import step2.exception.NotEnoughMoneyException;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyAmountTest {

    @DisplayName("create() 정적 생성자는 MoneyAmount 인스턴스를 반환한다")
    @ValueSource(ints = {0, 1000, 2000, 3000})
    @ParameterizedTest
    void create_Amount_MoneyAmountInstance(int amount) {
        Money money = Money.valueOf(amount);
        MoneyAmount moneyAmount = MoneyAmount.create(money);

        assertThat(moneyAmount).isInstanceOf(MoneyAmount.class);
        assertThat(moneyAmount.getRemainAmount()).isEqualTo(money);
    }

    @DisplayName("useAmount() 메소드는 입력 금액만큼 사용 금액을 증가시킨다")
    @Test
    void useAmount_UsedAmount_SubtractAmount() {
        MoneyAmount moneyAmount = LottoData.createMoneyAmount(1_000);
        moneyAmount.useAmount(Money.valueOf(1000));

        assertThat(moneyAmount.getUsedAmount()).isEqualTo(Money.valueOf(1_000));
    }

    @DisplayName("useAmount() 메소드는 입력한 금액이 보유 금액보다 클 경우 예외가 발생한다")
    @Test
    void useAmount_LessThenAmount_ExceptionThrown() {
        assertThatThrownBy(() -> LottoData.createMoneyAmount(999).useAmount(Money.valueOf(1000)))
                .isInstanceOf(NotEnoughMoneyException.class);
    }
}
