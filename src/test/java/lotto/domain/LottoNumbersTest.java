package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class LottoNumbersTest {

    // lottoTicket -> List<Integer> 로또 티켓 -> 난수 생성으로 6자리수 만든
    // lotto ->  lottoTickets = List<lottoTicket> : 메인 로직 짜면
    @Test
    void 로또티켓은_1에서45사이의_중복되지_않은_6개의_수이다() {
        assertThrows(IllegalArgumentException.class,
            () -> new LottoTicket(Arrays.asList(1, 2, 3, 2, 5, 6)));
    }
}