package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    private int INPUT_PURCHASED_PRICE = 3000;

    @Test
    void 구입금액을_입력한다() {
        Lotto lotto = new Lotto(INPUT_PURCHASED_PRICE);

        assertThat(lotto.getNumOfTicket()).isEqualTo(3);
    }
}
