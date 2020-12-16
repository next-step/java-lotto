package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTicketTest {

    @Test
    public void validLottoListNull(){
        assertThatThrownBy(() -> LottoTicket.validLottoList(null)).isInstanceOf(IllegalStateException.class);
    }
}
