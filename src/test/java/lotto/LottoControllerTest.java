package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoControllerTest {
    @Test
    void inputShouldBePositiveInt() {
        LottoController lottoController = new LottoController(14000);
        assertThat(lottoController.money).isPositive();
    }
}
