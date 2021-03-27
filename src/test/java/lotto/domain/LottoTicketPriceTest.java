package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketPriceTest {

    @Test
    @DisplayName("로또 가격 객체 생성")
    public void create() throws Exception {
        LottoTicketPrice lottoTicketPrice = new LottoTicketPrice();
        assertThat(lottoTicketPrice.price()).isEqualTo(1000);
    }
}
