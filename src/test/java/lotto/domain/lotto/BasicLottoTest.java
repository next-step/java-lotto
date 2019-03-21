package lotto.domain.lotto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BasicLottoTest {

    @Test
    public void 임의의_로또_생성() {
        Lotto lotto = new BasicLotto(new Ticket(1, 2, 3, 4, 5, 6));
        assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}
