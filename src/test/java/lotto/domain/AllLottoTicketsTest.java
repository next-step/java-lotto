package lotto.domain;

import lotto.factories.LottoTicketFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AllLottoTicketsTest {
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
        final AllLottoTickets expected = new AllLottoTickets(manualLottoTickets, autoLottoTickets);

        final AllLottoTickets result = new AllLottoTickets(manualLottoTickets, autoLottoTickets);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void manualLottoTicketsCount() {
        final AllLottoTickets allLottoTickets = new AllLottoTickets(manualLottoTickets, autoLottoTickets);

        assertThat(allLottoTickets.manualLottoTicketsCount()).isEqualTo(manualLottoTickets.size());
    }


    @Test
    public void autoLottoTicketsCount() {
        final AllLottoTickets allLottoTickets = new AllLottoTickets(manualLottoTickets, autoLottoTickets);

        assertThat(allLottoTickets.autoLottoTicketsCount()).isEqualTo(autoLottoTickets.size());
    }

    @Test
    public void allLottoTickets() {
        final AllLottoTickets allLottoTickets = new AllLottoTickets(manualLottoTickets, autoLottoTickets);

        assertThat(allLottoTickets.allLottoTickets()).isEqualTo(
                new LottoTickets(manualLottoTickets).combine(new LottoTickets(autoLottoTickets))
        );
    }
}
