package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.LottoNumber;
import lotto.domain.LottoRank;
import lotto.domain.LottoTicket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoTicketTest {

    private List<LottoNumber> numbers;
    private List<LottoNumber> winningNumbers;

    @BeforeEach
    void setUp() {
        numbers = List.of(new LottoNumber(1), new LottoNumber(2),
            new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        winningNumbers = List.of(new LottoNumber(1), new LottoNumber(2),
            new LottoNumber(3), new LottoNumber(4), new LottoNumber(9), new LottoNumber(10));
    }

    @Test
    void testGetLottoRankWithWinningNumbers() {
        LottoTicket lottoTicket = new LottoTicket(numbers);

        assertThat(lottoTicket.getRank(winningNumbers)).isEqualTo(LottoRank.THIRD);
    }

    @ParameterizedTest
    @MethodSource("lottoTicketCountTestArguments")
    void testGetLottoTicketCount(long paidAmount, int expectedCount) {
        assertThat(LottoTicket.getLottoTicketCount(paidAmount)).isEqualTo(expectedCount);
    }

    private static Stream<Arguments> lottoTicketCountTestArguments() {
        return Stream.of(
            Arguments.of(-1000, 0),
            Arguments.of(500, 0),
            Arguments.of(4400, 4),
            Arguments.of(10000, 10)
        );
    }

    @Test
    void testToString() {
        LottoTicket lottoTicket = new LottoTicket(numbers);

        assertThat(lottoTicket.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}
