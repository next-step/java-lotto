package step4.domain.money;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.domain.count.PassiveCount;
import step4.exception.InputNumberLessThanZeroException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
        assertThatThrownBy(() -> Money.valueOf(value))
                .isInstanceOf(InputNumberLessThanZeroException.class)
                .hasMessageContaining("0이하의 값이 입력되었습니다.");
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
        boolean actual = money.isNotAvailablePurchase(itemAmount, purchaseCount);

        // then
        assertThat(actual).isFalse();
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

        // then
        assertThat(actual).isEqualTo(7);
    }

    @DisplayName("Money 인스턴스가 소유한 돈의 크기 반환 여부 테스트")
    @Test
    void 반환_돈() {
        // given
        int expected = 10000;

        // when
        Money money = Money.valueOf(expected);
        int actual = money.getMoney();

        // then
        assertThat(actual).isEqualTo(expected);
    }


}