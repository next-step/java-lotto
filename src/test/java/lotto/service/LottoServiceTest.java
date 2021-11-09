package lotto.service;

import lotto.service.domain.LottoTicketRandomGenerator;
import lotto.service.dto.LottoPurchaseDTO;
import lotto.service.model.LottoTicket;
import lotto.service.model.LottoTickets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

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

    @Test
    @DisplayName("purchaseLottoTickets의 파라미터 값이 없는 경우 예외 발생 검증")
    void purchaseLottoTickets_exception() {
        assertThatNullPointerException().isThrownBy(() -> lottoService.purchaseLottoTickets(null));
    }

    @Test
    @DisplayName("lottoTicket 정상 생성여부 검증")
    void getWiningLottoTicket() {
        LottoTicket lottoTicket = lottoService.getWinningLottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lottoTicket).isNotNull();
    }

    @Test
    @DisplayName("getWinningLottoTicket의 파라미터 값이 없는 경우 예외 발생 검증")
    void getWinningLottoTicket_exception() {
        assertThatNullPointerException().isThrownBy(() -> lottoService.getWinningLottoTicket(null));
    }
}
