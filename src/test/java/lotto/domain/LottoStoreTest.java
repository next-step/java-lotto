package lotto.domain;

import lotto.domain.ticket.LottoTicket;
import lotto.domain.ticket.LottoTickets;
import lotto.support.LottoNumberConverter;
import lotto.vo.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LottoStoreTest {

    static Stream<Arguments> buyRequest() {
        return Stream.of(
                Arguments.of(Money.of(14000), createLottoTickets())
        );
    }

    private static LottoTickets createLottoTickets() {
        LottoTicket lottoTicket1 = new LottoTicket(LottoNumberConverter.of(Arrays.asList(1, 2, 3, 4, 5, 6)));
        LottoTicket lottoTicket2 = new LottoTicket(LottoNumberConverter.of(Arrays.asList(7, 1, 2, 4, 5, 6)));
        LottoTicket lottoTicket3 = new LottoTicket(LottoNumberConverter.of(Arrays.asList(1, 21, 3, 43, 12, 6)));

        return new LottoTickets(Arrays.asList(lottoTicket1, lottoTicket2, lottoTicket3));
    }

    @DisplayName("금액과 구매할 수동티켓을 입력하면 구매한 로또티켓을 반환한다")
    @MethodSource("buyRequest")
    @ParameterizedTest
    void buyTest(Money budget, LottoTickets manualLottoTickets) {
        //given
        LottoStore lottoStore = new LottoStore(new AutoLottoTicketGenerator());

        //when
        LottoTickets lottoTickets = lottoStore.buy(budget, manualLottoTickets);

        //then
        assertThat(lottoTickets.count()).isEqualTo(14);
    }

}
