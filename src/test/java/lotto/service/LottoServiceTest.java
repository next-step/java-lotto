package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.LottoTickets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoServiceTest {

    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        this.lottoService = LottoService.getInstance();
    }

    @ParameterizedTest
    @CsvSource(value = {"10000:10", "9000:9", "1000:1"}, delimiter = ':')
    void 금액에_맞게_로또_생성(Integer money, Integer count) {
        LottoTickets tickets = lottoService.buyLottoTickets(money);
        assertThat(tickets.size()).isEqualTo(count);
    }

}
