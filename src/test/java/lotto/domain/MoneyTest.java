package lotto.domain;

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

    @DisplayName("입력 금액이 최저금액인 천원보다 작으면 IllegalArgumentException을 반환한다")
    @Test
    public void should_throw_exception_input_value_under_than_lowest_amount() throws Exception {
        //arrange, act, assert
        assertThatIllegalArgumentException().isThrownBy(() -> Money.of(100));
    }
}