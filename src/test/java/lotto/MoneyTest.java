package lotto;

import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class MoneyTest {

    @Test
    @DisplayName("음수 테스트")
    public void negativeException(){
        assertThatThrownBy(() -> new Money(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("음수가 들어왔습니다.");
    }

    @Test
    @DisplayName("1000원 단위 입력 테스트")
    public void thousandWonException(){
        assertThatThrownBy(() -> new Money(1999))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1000원 단위로 입력해주세요");
    }

    @Test
    @DisplayName("1000원 미만 금액 입력 테스트")
    public void moneyException(){
        assertThatThrownBy(() -> new Money(99))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1000원 이상을 입력해야합니다.");
    }
}
