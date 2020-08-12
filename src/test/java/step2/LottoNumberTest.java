package step2;

import org.junit.jupiter.api.Test;
import step2.domain.LottoNumber;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {
    @Test
    void constructor() {
        LottoNumber ticketNumber = new LottoNumber(1);

        assertThat(ticketNumber).isEqualTo(new LottoNumber(1));
    }

    @Test
    void invalid() {
        assertThatThrownBy(() -> new LottoNumber(LottoNumber.MIN_NUMBER - 1));
        assertThatThrownBy(() -> new LottoNumber(LottoNumber.MAX_NUMBER + 1));
    }
}
