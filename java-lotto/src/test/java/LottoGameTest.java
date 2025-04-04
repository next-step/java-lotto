import domain.LottoResult;
import domain.LottoService;
import domain.LottoTicket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoGameTest {

    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
    }

    @Test
    void 로또_티켓_개수_생성_확인() {
        List<LottoTicket> tickets = lottoService.generateLottoTickets(5);
        assertEquals(5, tickets.size());
    }

    @Test
    void 로또_티켓_숫자_개수_확인() {
        LottoTicket ticket = new LottoTicket();
        assertEquals(6, ticket.toString().replaceAll("[^0-9,]", "").split(",").length);
    }

    @Test
    void 로또_당첨_숫자_일치_카운트() {
        LottoTicket ticket = new LottoTicket() {
            @Override
            public String toString() {
                return List.of(1, 2, 3, 4, 5, 6).toString();
            }

            @Override
            public int getMatchCount(List<Integer> winningNumbers) {
                return (int) List.of(1, 2, 3, 4, 5, 6).stream().filter(winningNumbers::contains).count();
            }
        };

        int matchCount = ticket.getMatchCount(List.of(1, 2, 3, 10, 11, 12));
        assertEquals(3, matchCount);
    }

    @Test
    void 당첨_통계_계산_테스트() {
        List<LottoTicket> tickets = List.of(
                mockTicketWithMatchCount(3),
                mockTicketWithMatchCount(4),
                mockTicketWithMatchCount(5),
                mockTicketWithMatchCount(0)
        );
        LottoResult result = lottoService.calculateResults(tickets, List.of());
        Map<Integer, Integer> matchCounts = result.getMatchCounts();
        assertEquals(1, matchCounts.get(3));
        assertEquals(1, matchCounts.get(4));
        assertEquals(1, matchCounts.get(5));
    }

    @Test
    void 수익률_계산_정확성_테스트() {
        Map<Integer, Integer> matchCounts = Map.of(
                3, 1,
                4, 1,
                5, 0,
                6, 0
        );
        LottoResult result = new LottoResult(matchCounts);
        double profitRate = result.calculateProfitRate(3000);
        int expectedPrize = 5000 + 50000;
        assertEquals((double) expectedPrize / 3000, profitRate);
    }

    private LottoTicket mockTicketWithMatchCount(int count) {
        return new LottoTicket() {
            @Override
            public int getMatchCount(List<Integer> winningNumbers) {
                return count;
            }
        };
    }
}