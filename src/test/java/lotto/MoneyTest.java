package lotto;

import lotto.model.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {

    @Test
    @DisplayName("음수값을 가진 돈 생성시 예외")
    void 음수_돈_예외(){
        assertThatThrownBy(()->{
            new Money(-1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("돈 더하기 곱하기 나누기 테스트")
    void operator_test(){
        Money a = new Money(10);
        Money b = new Money(2);

        assertThat(a.divide(b)).isEqualTo(5);
        assertThat(a.add(b)).isEqualTo(new Money(12));
        assertThat(a.multiply(3)).isEqualTo(new Money(30));
    }

    @Test
    @DisplayName("티겟 몇장 살 수 있는지 테스트")
    void ticket_cnt_test(){
        Money a = new Money(51000);
        assertThat(a.calculateTicketCnt()).isEqualTo(51);
    }

    @Test
    @DisplayName("돈이 1000의 배수가 아닐때 예외를 던진다.")
    void ticket_cnt_exception_test(){
        Money a = new Money(51030);
        assertThatThrownBy(a::calculateTicketCnt).isInstanceOf(IllegalArgumentException.class);
    }
}
