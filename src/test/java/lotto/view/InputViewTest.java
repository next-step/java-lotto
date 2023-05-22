package lotto.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

class InputViewTest {

    @Test
    void 금액_입력_받기() {
        // Given
        String testInput = "10000";
        ByteArrayInputStream in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        // When
        InputView inputView = new InputView();

        // Then
        Assertions.assertThat(inputView.purchasePriceIsEqualTo(10000)).isTrue();
    }
}