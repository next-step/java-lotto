package lotto.service;

import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoManualServiceTest {

    @Test
    @DisplayName("수동로또 - 구매번호 미입력 : null")
    void nullInput() {
        // given
        LottoManualService lottoManualService = new LottoManualService();

        // when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lottoManualService.purchaseLottoTicket(null));
    }

    @Test
    @DisplayName("수동로또 - 구매번호 미입력 : 빈 리스트")
    void emptyInput() {
        // given
        LottoManualService lottoManualService = new LottoManualService();

        // when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lottoManualService.purchaseLottoTicket(new ArrayList<>()));
    }

    @Test
    @DisplayName("로또 구매결과 구매장수만큼의 티켓 카운트가 존재해야 한다.")
    void purchaseCount() {
        // given
        List<String> manualLottoPurchaseNumberList = Arrays.asList("1, 2, 3, 4, 5, 6", "2, 3, 4, 5, 6, 7", "3, 4, 5, 6, 7, 8");
        LottoManualService lottoManualService = new LottoManualService();

        // when
        LottoTicket lottoTicket = lottoManualService.purchaseLottoTicket(manualLottoPurchaseNumberList);

        // then
        assertThat(3).isEqualTo(lottoTicket.getCount());
    }

    @Test
    @DisplayName("로또 구매결과 티켓타입은 수동 티켓이다.")
    void ticketType_Manual() {
        // given
        List<String> manualLottoPurchaseNumberList = Arrays.asList("1, 2, 3, 4, 5, 6", "2, 3, 4, 5, 6, 7", "3, 4, 5, 6, 7, 8");
        LottoManualService lottoManualService = new LottoManualService();

        // when
        LottoTicket lottoTicket = lottoManualService.purchaseLottoTicket(manualLottoPurchaseNumberList);

        // then
        assertThat(LottoTicketType.MANUAL.equals(lottoTicket.getLottoTicketType())).isTrue();
    }
}