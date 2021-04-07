package step4.domain.money;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.domain.count.PassiveCount;
import step4.exception.InputNegativeAmountException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @DisplayName("Money 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        int value = 1;

        // when
        Money money = Money.valueOf(value);

        // then
        assertThat(money).isNotNull();
    }

    @DisplayName("Money 인스턴스에 음수 입력시 예외처리 여부 테스트")
    @Test
    void 검증_음수() {
        // given
        int value = -1;

        // when
        assertThatThrownBy(()-> Money.valueOf(value))
                .isInstanceOf(InputNegativeAmountException.class)
                .hasMessageContaining("음수값이 입력되었습니다.");
    }

    @DisplayName("Money 인스턴스가 특정 값을 기준으로 구매할 수 있는 갯수 반환 여부 테스트")
    @Test
    void 검증_구매할_수_있는_갯수_반환() {
        // given
        int value = 10000;
        int purchaseAmount = 1000;

        // when
        Money money = Money.valueOf(value);
        int actual = money.purchaseQuantity(purchaseAmount);

        assertThat(actual).isEqualTo(10);
    }

    @DisplayName("Money 인스턴스가 특정 값을 기준으로 구매할 수 있는지 여부 테스트")
    @Test
    void 반환_구매할_수_있는_갯수() {
        // given
        int value = 10000;
        int itemAmount = 1000;
        int purchaseCount = 10;

        // when
        Money money = Money.valueOf(value);
        boolean actual = money.isAvailablePurchase(itemAmount, purchaseCount);

        assertThat(actual).isTrue();
    }

    @DisplayName("Money 인스턴스가 특정 값을 기준으로 구매할 수 있는지 여부 테스트")
    @Test
    void 검증_구매할_수_있는_갯수인지_확인() {
        // given
        int value = 10000;
        int itemAmount = 1000;
        int purchaseCount = 10;

        // when
        Money money = Money.valueOf(value);
        boolean actual = money.isAvailablePurchase(itemAmount, purchaseCount);

        assertThat(actual).isTrue();
    }

    @DisplayName("Money 인스턴스가 특정 값을 기준으로 앞으로 몇 개 더 구매할 수 있는지 여부 테스트")
    @Test
    void 반환_구매가능한_갯수() {
        // given
        PassiveCount passiveCount = PassiveCount.valueOf(3);
        int value = 10000;
        int itemAmount = 1000;

        // when
        Money money = Money.valueOf(value);
        int actual = money.availablePurchaseCount(itemAmount, passiveCount);

        assertThat(actual).isEqualTo(7);
    }


}