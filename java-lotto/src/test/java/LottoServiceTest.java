import domain.Lotto.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoServiceTest {

    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
    }

    @Test
    void generateLottoTickets_요청한_개수만큼_티켓을_생성한다() {
        int count = 5;
        List<LottoTicket> tickets = lottoService.generateLottoTickets(count);

        assertThat(tickets).hasSize(count);
        for (LottoTicket ticket : tickets) {
            assertThat(ticket.getNumbers()).hasSize(6);
        }
    }

    @Test
    void calculateResults_로또_결과를_정확히_계산한다() {
        // 당첨 번호 및 보너스 번호 세팅
        List<LottoNo> winningNumbers = List.of(1, 2, 3, 4, 5, 6).stream()
                .map(LottoNo::new)
                .collect(Collectors.toList());
        LottoNo bonus = new LottoNo(7);
        WinningLotto winningLotto = new WinningLotto(new LottoTicket(winningNumbers, true), bonus);

        // 티켓 준비
        LottoTicket match3 = new LottoTicket(List.of(1, 2, 3, 10, 11, 12).stream()
                .map(LottoNo::new)
                .collect(Collectors.toList()), true);

        LottoTicket match6 = new LottoTicket(List.of(1, 2, 3, 4, 5, 6).stream()
                .map(LottoNo::new)
                .collect(Collectors.toList()), true);

        LottoTicket miss = new LottoTicket(List.of(10, 11, 12, 13, 14, 15).stream()
                .map(LottoNo::new)
                .collect(Collectors.toList()), true);

        List<LottoTicket> tickets = List.of(match3, match6, miss);

        // 결과 계산
        LottoResult result = lottoService.calculateResults(tickets, winningLotto);

        // 결과 검증
        Map<Rank, Integer> matchCounts = result.getMatchCounts();
        assertThat(matchCounts.getOrDefault(Rank.THIRD, 0)).isEqualTo(1);
        assertThat(matchCounts.getOrDefault(Rank.FIFTH, 0)).isEqualTo(1);
        assertThat(matchCounts.getOrDefault(Rank.MISS, 0)).isEqualTo(1);
    }
}