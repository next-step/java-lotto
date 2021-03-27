package lotto.domain;

import lotto.factories.LottoTicketFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsTest {
    private List<LottoTicket> lottoTicketList;

    @BeforeEach
    void setUp() {
        lottoTicketList = Arrays.asList(
                LottoTicketFactory.createAutoLottoTicket(),
                LottoTicketFactory.createAutoLottoTicket(),
                LottoTicketFactory.createAutoLottoTicket(),
                LottoTicketFactory.createAutoLottoTicket(),
                LottoTicketFactory.createAutoLottoTicket(),
                LottoTicketFactory.createAutoLottoTicket(),
                LottoTicketFactory.createAutoLottoTicket(),
                LottoTicketFactory.createAutoLottoTicket(),
                LottoTicketFactory.createAutoLottoTicket(),
                LottoTicketFactory.createAutoLottoTicket()
        );
    }

    @Test
    public void create() {
        assertThat(new LottoTickets(lottoTicketList)).isEqualTo(new LottoTickets(lottoTicketList));
    }

    @Test
    public void lottoRanks() {
        final LottoDiscriminator lottoDiscriminator = new LottoDiscriminator(
                new LottoTicket(
                        Arrays.asList(
                                LottoNumber.of(1),
                                LottoNumber.of(2),
                                LottoNumber.of(3),
                                LottoNumber.of(4),
                                LottoNumber.of(5),
                                LottoNumber.of(6)
                        )
                ),
                LottoNumber.of(7)
        );

        final List<LottoRank> expected = lottoTicketList.stream()
                .map(lottoDiscriminator::lottoRank)
                .collect(Collectors.toList());

        final LottoTickets lottoTickets = new LottoTickets(lottoTicketList);
        final List<LottoRank> result = lottoTickets.lottoRanks(lottoDiscriminator);

        assertThat(result).isEqualTo(expected);
    }
}
