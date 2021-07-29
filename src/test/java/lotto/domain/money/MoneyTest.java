package lotto.domain.money;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MoneyTest {

    @DisplayName("입력 금액이 최저금액인 천원보다 크면 Money객체를 생성한다")
    @Test
    public void should_make_object_over_input_value_more_than_lowest_amount() throws Exception {
        //arrange
        Money money = Money.of(2000);

        //act, assert
        assertThat(money).isEqualTo(Money.of(2000));
    }

    @DisplayName("로또가격 (천원)과 비교하여 현재 Money로 몇개를 살수 있는지 count한다")
    @Test
    public void should_get_available_purchase_count() throws Exception {
        //arrange
        Money money = Money.of(14000);

        //act, assert
        assertThat(money.getPurchasableQuantity(Money.of(1000))).isEqualTo(14);
    }
}