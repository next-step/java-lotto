package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    @Test
    @DisplayName("로또 티켓 생성")
    public void create() throws Exception {
        LottoTicket lottoTicket = new LottoTicket(new LottoNumbers());
        assertThat(lottoTicket).isEqualTo(new LottoTicket(LottoNumbers.from(
                lottoTicket.lottoNumbers()
                        .stream()
                        .map(LottoNumber::lottoNumber)
                        .collect(Collectors.toList()))));
    }
}
