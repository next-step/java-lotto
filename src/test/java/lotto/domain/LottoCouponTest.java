package lotto.domain;

import lotto.factories.LottoTicketFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

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
    public void create_lessThanZero() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoCoupon(-1);
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 11})
    public void validateExchangeable(int count) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            final LottoCoupon lottoCoupon = new LottoCoupon(exchangeableTicketsCount);

            lottoCoupon.validateExchangeable(count);
        });
    }

    @Test
    public void lottoBuyer() {
        final LottoCoupon lottoCoupon = new LottoCoupon(exchangeableTicketsCount);

        final LottoBuyer lottoBuyer = lottoCoupon.lottoBuyer();

        assertThat(lottoBuyer.allLottoTickets().count()).isEqualTo(exchangeableTicketsCount);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 10})
    public void lottoBuyerWithManualLottoTickets(int manualLottoTicketsCount) {
        final List<LottoTicket> manualLottoTickets = Stream.generate(LottoTicketFactory::createAutoLottoTicket)
                .limit(manualLottoTicketsCount)
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
                    .limit(exchangeableTicketsCount + 1)
                    .collect(Collectors.toList());

            lottoCoupon.lottoBuyer(manualLottoTickets);
        });
    }
}
