package lotto.view;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {


    @Test
    void insertPrice() {
        final int expect = 1000;

        final int actual = InputView.inputPrice();

        assertThat(actual).isEqualTo(expect);
    }
}