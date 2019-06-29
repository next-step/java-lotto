package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

public class MoneyTest {

    @Test
    @DisplayName("Money 객체 생성")
    void new_money() {
        assertThat(new Money(14_000L).getMoney()).isEqualTo(14_000L);
    }

    @Test
    @DisplayName("마이너스 금액은 생성할 수 없다.")
    void negative_money() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Money(-14_000L));
    }

    @Test
    @DisplayName("돈 곱하기 테스트")
    void multiply() {
        Money originMoney = new Money(1_000L);
        assertThat(originMoney.multiplyMoney(3)).isEqualTo(new Money(3_000L));
    }

    @Test
    @DisplayName("돈 빼기 테스트")
    void subtract() {
        Money originMoney = new Money(2_000L);
        assertThat(originMoney.subtractMoney(new Money(1_000L))).isEqualTo(new Money(1_000L));
    }

    @Test
    @DisplayName("돈으로 구매할 수 있는 로또 수량 구하기")
    void get_quantity() {
        Money originMoney = new Money(1_000L);
        assertThat(originMoney.getLottoQuantity(LottoStore.LOTTO_PRICE)).isEqualTo(new LottoQuantity(1L));
    }

    @Test
    @DisplayName("Money 객체 equalsAndHashCode test")
    void equals() {
        Money money1 = new Money(1_000L);
        Money money2 = new Money(1_000L);
        assertAll(
            () -> assertThat(money1).isEqualTo(money2),
            () -> assertThat(money1).hasSameHashCodeAs(money2)
        );
    }
}
