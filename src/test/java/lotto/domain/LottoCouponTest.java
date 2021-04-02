package lotto.domain;

import lotto.factories.LottoTicketFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

// TODO: 리팩토링 필요
public class LottoCouponTest {
    private int exchangeableTicketsCount;

    @BeforeEach
    public void setUp() {
        exchangeableTicketsCount = 10;
    }

    @Test
    public void create() {
        final LottoCoupon expected = new LottoCoupon(exchangeableTicketsCount);

        final LottoCoupon result = new LottoCoupon(exchangeableTicketsCount);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void exchangeable() {
        final LottoCoupon lottoCoupon = new LottoCoupon(exchangeableTicketsCount);

        assertThat(lottoCoupon.exchangeable(6)).isTrue();
    }


    @Test
    public void lottoBuyer() {
        final LottoCoupon lottoCoupon = new LottoCoupon(exchangeableTicketsCount);

        final LottoBuyer lottoBuyer = lottoCoupon.lottoBuyer();

        assertThat(lottoBuyer.allLottoTickets().count()).isEqualTo(exchangeableTicketsCount);
    }

    @Test
    public void lottoBuyerWithManualLottoTickets() {
        final List<LottoTicket> manualLottoTickets = Stream.generate(LottoTicketFactory::createAutoLottoTicket)
                .limit(3)
                .collect(Collectors.toList());
        final LottoCoupon lottoCoupon = new LottoCoupon(exchangeableTicketsCount);

        final LottoBuyer lottoBuyer = lottoCoupon.lottoBuyer(manualLottoTickets);

        assertThat(lottoBuyer.manualLottoTicketsCount()).isEqualTo(manualLottoTickets.size());
    }

    @DisplayName("수동 로또 티켓 수가 교환 가능한 티켓 수를 넘으면 예외 발생")
    @Test
    public void lottoBuyer_ThrowsException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            final LottoCoupon lottoCoupon = new LottoCoupon(exchangeableTicketsCount);

            final List<LottoTicket> manualLottoTickets = Stream.generate(LottoTicketFactory::createAutoLottoTicket)
                    .limit(exchangeableTicketsCount + 10)
                    .collect(Collectors.toList());

            lottoCoupon.lottoBuyer(manualLottoTickets);
        });
    }
}
