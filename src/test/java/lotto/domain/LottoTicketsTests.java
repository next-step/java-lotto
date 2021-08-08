package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsTests {

    @DisplayName(" LottoTickets 생성 테스트")
    @Test
    void create() {
        LottoTicket actualLottoTicket = LottoTicket.of(new TreeSet<>(Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6))));
        LottoTickets actualLottoTickets = LottoTickets.of(Arrays.asList(actualLottoTicket));

        LottoTicket expectedLottoTicket = LottoTicket.of(new TreeSet<>(Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6))));
        LottoTickets expectedLottoTickets = LottoTickets.of(Arrays.asList(expectedLottoTicket));

        assertThat(actualLottoTickets).isEqualTo(expectedLottoTickets);
    }

}
