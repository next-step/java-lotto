package lotto.service;

import lotto.service.LottoService;
import lotto.service.domain.LottoTicketRandomGenerator;
import lotto.service.dto.LottoPurchaseDTO;
import lotto.service.model.LottoTickets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {
    private LottoService lottoService;

    @BeforeEach
    void setup() {
        lottoService = new LottoService(new LottoTicketRandomGenerator());
    }

    @Test
    @DisplayName("lottoTickets 정상 생성여부 검증")
    void purchaseLottoTickets() {
        Integer purchaseQuantity = 5;
        LottoPurchaseDTO lottoPurchaseDTO = LottoPurchaseDTO.from(purchaseQuantity);
        LottoTickets lottoTickets = lottoService.purchaseLottoTickets(lottoPurchaseDTO);
        assertThat(lottoTickets).isNotNull();
        assertThat(lottoTickets.getLottoTicketsCount()).isEqualTo(purchaseQuantity);
    }
}
