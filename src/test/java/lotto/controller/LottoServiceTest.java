package lotto.controller;

import lotto.domain.LottoService;
import lotto.domain.LottoTicket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoServiceTest {
    private LottoService lottoService;
    private List<LottoTicket> lottoTickets;

    @BeforeEach
    public void beforeEach(){
        lottoService = new LottoService();
    }

    @DisplayName("로또 구매 개수 확인 테스트")
    @Test
    public void buyLottoTicketsTest(){
        int numberOfTickets = 5;
        lottoService.buyLottoTickets(numberOfTickets);
        int size = lottoService.getLottoTickets().size();
        assertThat(size).isEqualTo(numberOfTickets);
    }
}
