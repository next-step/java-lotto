package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

/**
 * @author han
 */
public class PurchaseMachineTest {

    @Test
    @DisplayName("잘못된 값을 입력했을 경우, 에러를 던진다")
    void throwException() {
        assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> new PurchaseMachine(new Credit("nunono")));
    }

    @Test
    @DisplayName("로또 구입")
    void purchase() {
        PurchaseMachine machine = new PurchaseMachine(new Credit("14000"));
        PurchaseMachine purchase = machine.purchase();
        assertThat(purchase.getLotto().size()).isEqualTo(14);
    }
}
