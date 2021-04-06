package lotto.service;

import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoAutoServiceTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    @DisplayName("로또 갯수는 1개 이상이어야 한다.")
    void purchaseLottoTicket(int purchaseCount) {
        // given
        LottoAutoService lottoAutoService = new LottoAutoService();

        // when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lottoAutoService.purchaseLottoTicket(purchaseCount))
                .withMessageMatching("최소 1개 이상의 구매수량을 입력해 주세요");
    }

    @Test
    @DisplayName("로또 구매결과 구매장수만큼의 티켓 카운트가 존재해야 한다.")
    void purchaseCount() {
        // given
        int purchaseCount = 14;
        LottoAutoService lottoAutoService = new LottoAutoService();

        // when
        LottoTicket lottoTicket = lottoAutoService.purchaseLottoTicket(purchaseCount);

        // then
        assertThat(purchaseCount).isEqualTo(lottoTicket.getCount());
    }

    @Test
    @DisplayName("로또 구매결과 티켓타입은 자동 티켓이다.")
    void ticketType_Auto() {
        // given
        int purchaseCount = 14;
        LottoAutoService lottoAutoService = new LottoAutoService();

        // when
        LottoTicket lottoTicket = lottoAutoService.purchaseLottoTicket(purchaseCount);

        // then
        assertThat(LottoTicketType.AUTO.equals(lottoTicket.getLottoTicketType())).isTrue();
    }

}