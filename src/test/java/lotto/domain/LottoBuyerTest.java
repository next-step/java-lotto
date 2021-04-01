package lotto.domain;

import lotto.factories.LottoTicketFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoBuyerTest {
    private List<LottoTicket> manualLottoTickets;
    private List<LottoTicket> autoLottoTickets;

    @BeforeEach
    void setUp() {
        manualLottoTickets = Arrays.asList(
                LottoTicketFactory.createAutoLottoTicket(),
                LottoTicketFactory.createAutoLottoTicket(),
                LottoTicketFactory.createAutoLottoTicket(),
                LottoTicketFactory.createAutoLottoTicket()
        );
        autoLottoTickets = Arrays.asList(
                LottoTicketFactory.createAutoLottoTicket(),
                LottoTicketFactory.createAutoLottoTicket(),
                LottoTicketFactory.createAutoLottoTicket(),
                LottoTicketFactory.createAutoLottoTicket()
        );
    }


    @Test
    public void create() {
        final LottoBuyer expected = new LottoBuyer(manualLottoTickets, autoLottoTickets);

        final LottoBuyer result = new LottoBuyer(manualLottoTickets, autoLottoTickets);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void manualLottoTicketsCount() {
        final LottoBuyer lottoBuyer = new LottoBuyer(manualLottoTickets, autoLottoTickets);

        assertThat(lottoBuyer.manualLottoTicketsCount()).isEqualTo(manualLottoTickets.size());
    }


    @Test
    public void autoLottoTicketsCount() {
        final LottoBuyer lottoBuyer = new LottoBuyer(manualLottoTickets, autoLottoTickets);

        assertThat(lottoBuyer.autoLottoTicketsCount()).isEqualTo(autoLottoTickets.size());
    }

    @Test
    public void allLottoTickets() {
        final LottoBuyer lottoBuyer = new LottoBuyer(manualLottoTickets, autoLottoTickets);

        assertThat(lottoBuyer.allLottoTickets()).isEqualTo(
                new LottoTickets(manualLottoTickets).combine(new LottoTickets(autoLottoTickets))
        );
    }
}
