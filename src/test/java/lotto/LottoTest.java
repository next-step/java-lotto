package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    private int INPUT_PURCHASED_PRICE = 3000;

    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto(INPUT_PURCHASED_PRICE);
    }

    @Test
    void 구입금액을_입력한다() {
        assertThat(lotto.getNumOfTicket()).isEqualTo(3);
    }
}
