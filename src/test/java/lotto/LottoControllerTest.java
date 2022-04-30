package lotto;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoControllerTest {
    LottoController lottoController = new LottoController(14000);

    @Test
    void shouldCreateMoney() {
        assertThat(lottoController.money).isInstanceOf(Money.class);
    }
}
