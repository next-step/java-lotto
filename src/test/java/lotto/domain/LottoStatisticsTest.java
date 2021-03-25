package lotto.domain;

import lotto.factories.LottoTicketFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStatisticsTest {
    private LottoDiscriminator lottoDiscriminator;
    private List<LottoTicket> lottoTickets;

    @BeforeEach
    public void setUp() {
        final LottoTicket winningTicket = LottoTicketFactory.createAutoLottoTicket();
        lottoDiscriminator = new LottoDiscriminator(winningTicket);
        lottoTickets = Stream.generate(LottoTicketFactory::createAutoLottoTicket)
                .limit(100)
                .collect(Collectors.toList());
    }

    @Test
    public void create() {
        final LottoStatistics expected = new LottoStatistics(lottoDiscriminator, lottoTickets);
        final LottoStatistics result = new LottoStatistics(lottoDiscriminator, lottoTickets);

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"FIRST", "SECOND", "THIRD", "FOURTH", "FIFTH", "MISS"})
    public void lottoTicketsCount(String LottoRankInput) {
        final LottoRank lottoRank = LottoRank.valueOf(LottoRankInput);
        final int expected = (int) lottoTickets.stream().filter(e -> lottoDiscriminator.lottoRank(e) == lottoRank).count();

        final LottoStatistics lottoStatistics = new LottoStatistics(lottoDiscriminator, lottoTickets);
        final int result = lottoStatistics.lottoTicketsCount(lottoRank);

        assertThat(result).isEqualTo(expected);
    }
}
