package lotto;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoShop;
import lotto.domain.ticket.LottoTicket;
import lotto.domain.ticket.LottoTicketAutoGenerator;
import lotto.domain.ticket.LottoTicketManualGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoShopTest {

    private LottoShop lottoShop;

    @BeforeEach
    void setUp() {
        lottoShop = new LottoShop(new LottoTicketManualGenerator(), new LottoTicketAutoGenerator());
    }

    @CsvSource(value = {"0:1", "1:2", "2:3", "3:4"}, delimiter = ':')
    @ParameterizedTest
    @DisplayName("로또를 구입하고 크기를 검증한다.")
    void 로또_구입_테스트(int autoAmount, int expectedSize) {
        List<LottoNumbers> lottoNumbersList = Arrays.asList(LottoNumbers.of(1, 2, 3, 4, 5, 6));
        List<LottoTicket> lottoTickets = lottoShop.buy(lottoNumbersList, autoAmount);
        assertThat(lottoTickets).hasSize(expectedSize);
    }
}
