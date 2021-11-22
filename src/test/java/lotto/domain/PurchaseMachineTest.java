package lotto.domain;

import calculator.PositiveNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author han
 */
public class PurchaseMachineTest {

    @Test
    @DisplayName("로또 구입")
    void purchase() {
        PurchaseMachine machine = new PurchaseMachine(new PositiveNumber(14000), Collections.emptyList());
        PurchaseMachine purchase = machine.purchase();
        assertThat(purchase.getCredit().getNumber()).isEqualTo(14000);
        assertThat(purchase.getLottoList().size()).isEqualTo(14);
    }
}
