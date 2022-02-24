package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class LottoTicketTest {

    @Test
    void 로또티켓은_1에서45사이의_중복되지_않은_6개의_수이다() {
        assertThrows(IllegalArgumentException.class,
            () -> new LottoTicket(1, 2, 3, 3, 5, 6));
    }

    @Test
    void 로또티켓은_1에서45사이의_중복되지_않은_6개의_수이며_LottoNumber로받을_수_있다() {
        final List<LottoNumber> numbers = Arrays.asList(
            LottoNumber.from(1),
            LottoNumber.from(1),
            LottoNumber.from(3),
            LottoNumber.from(4),
            LottoNumber.from(5),
            LottoNumber.from(6));
        assertThrows(IllegalArgumentException.class,
            () -> new LottoTicket(numbers));
    }
}
