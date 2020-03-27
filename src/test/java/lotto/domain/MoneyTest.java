package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {

    @DisplayName("생성자 테스트")
    @Test
    public void construct() throws Exception {
        //given
        Money money1 = new Money(1000);
        Money money2 = new Money(1000);

        //then
        assertThat(money1.equals(money2)).isTrue();
    }

    @DisplayName("양의 정수인지 체크")
    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -10, -100})
    public void validatePositive(int money) throws Exception {
        //given
        assertThatThrownBy(
                () -> new Money(money)
        ).isInstanceOf(IllegalArgumentException.class).hasMessage("금액은 양의 정수만 입력 가능 합니다.");
    }
}
