package lotto.domain;

import lotto.factories.LottoTicketFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStatisticsTest {
    private LottoDiscriminator lottoDiscriminator;
    private List<LottoTicket> lottoTickets;

    @BeforeEach
    public void setUp() {
        final List<LottoNumber> winningNumbers = Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        );
        lottoDiscriminator = new LottoDiscriminator(winningNumbers);
        lottoTickets = Stream.generate(LottoTicketFactory::createAutoLottoTicket)
                .limit(20)
                .collect(Collectors.toList());
    }

    @Test
    public void create() {
        final LottoStatistics expected = new LottoStatistics(lottoDiscriminator, lottoTickets);
        final LottoStatistics result = new LottoStatistics(lottoDiscriminator, lottoTickets);

        assertThat(result).isEqualTo(expected);
    }


    private int matchingLottoTicketsCount(final int matchingCount) {
        return (int) lottoTickets.stream().filter(e -> lottoDiscriminator.matchingCount(e) == matchingCount).count();
    }

    @Test
    public void threeMatchingLottoTicketsCount() {
        final int expected = matchingLottoTicketsCount(3);

        final LottoStatistics lottoStatistics = new LottoStatistics(lottoDiscriminator, lottoTickets);
        final int result = lottoStatistics.threeMatchingLottoTicketsCount();

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void FourMatchingLottoTicketsCount() {
        final int expected = matchingLottoTicketsCount(4);

        final LottoStatistics lottoStatistics = new LottoStatistics(lottoDiscriminator, lottoTickets);
        final int result = lottoStatistics.fourMatchingLottoTicketsCount();

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void FiveMatchingLottoTicketsCount() {
        final int expected = matchingLottoTicketsCount(5);

        final LottoStatistics lottoStatistics = new LottoStatistics(lottoDiscriminator, lottoTickets);
        final int result = lottoStatistics.fiveMatchingLottoTicketsCount();

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void SixMatchingLottoTicketsCount() {
        final int expected = matchingLottoTicketsCount(6);

        final LottoStatistics lottoStatistics = new LottoStatistics(lottoDiscriminator, lottoTickets);
        final int result = lottoStatistics.sixMatchingLottoTicketsCount();

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void yield() {
        final LottoStatistics lottoStatistics = new LottoStatistics(lottoDiscriminator, lottoTickets);

        final int payment = 2000;
        final long threeMatchingLottoTicketsPrize =
                LottoStatistics.THREE_MATCHING_PRIZE * lottoStatistics.threeMatchingLottoTicketsCount();
        final long fourMatchingLottoTicketsPrize =
                LottoStatistics.FOUR_MATCHING_PRIZE * lottoStatistics.fourMatchingLottoTicketsCount();
        final long fiveMatchingLottoTicketsPrize =
                LottoStatistics.FIVE_MATCHING_PRIZE * lottoStatistics.fiveMatchingLottoTicketsCount();
        final long sixMatchingLottoTicketsPrize =
                LottoStatistics.SIX_MATCHING_PRIZE * lottoStatistics.sixMatchingLottoTicketsCount();

        final long totalPrize = threeMatchingLottoTicketsPrize + fourMatchingLottoTicketsPrize +
                fiveMatchingLottoTicketsPrize + sixMatchingLottoTicketsPrize;
        final double expected = (double) totalPrize / payment;

        final double result = lottoStatistics.yield(payment);

        assertThat(result).isEqualTo(expected);
    }
}
