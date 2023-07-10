package lotto.input;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoInputTest {

    private final InputStream standardInput = System.in;

    @AfterEach
    void tearDown() {
        System.setIn(standardInput);
    }

    @Test
    @DisplayName("구입 금액을 받는다.")
    void priceInputTest() {
        //given
        InputStream stream = new ByteArrayInputStream("14000\n".getBytes());
        System.setIn(stream);
        LottoInput lottoInput = new LottoInput();

        //when, then
        assertThat(lottoInput.inputAmount()).isEqualTo(14000);
    }
}