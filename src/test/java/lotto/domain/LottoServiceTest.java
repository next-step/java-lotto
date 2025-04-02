package lotto.domain;

import lotto.domain.model.game.LottoGameResult;
import lotto.domain.model.lotto.*;
import lotto.domain.model.game.Rank;
import lotto.domain.model.lotto.BonusNumber;
import lotto.domain.model.lotto.LottoNumber;
import lotto.domain.model.lotto.LottoTicket;
import lotto.domain.model.lotto.WinningLottoTicket;
import lotto.domain.model.lotto.TotalTicketCount;
import lotto.domain.model.lotto.TicketCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoServiceTest {

    private final LottoService lottoService = new LottoService();

    @DisplayName("자동 로또 티켓 구매 테스트")
    @Test
    void purchaseOnlyAutoTickets() {
        List<LottoTicket> manualTickets = new ArrayList<>();
        int totalCount = 5;
        TotalTicketCount totalTicketCount = new TotalTicketCount(
            new TicketCount(totalCount),
            new TicketCount(0)
        );

        List<LottoTicket> tickets = lottoService.purchaseTickets(manualTickets, totalTicketCount);

        assertThat(tickets).hasSize(totalCount);
    }

    @DisplayName("로또 티켓 구매 수량 계산 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 5, 10})
    void calculateTicketCount(int count) {
        List<LottoTicket> manualTickets = new ArrayList<>();
        TotalTicketCount totalTicketCount = new TotalTicketCount(
            new TicketCount(count), 
            new TicketCount(0)
        );

        List<LottoTicket> tickets = lottoService.purchaseTickets(manualTickets, totalTicketCount);

        assertThat(tickets).hasSize(count);
    }

    @DisplayName("로또 게임 결과 계산 테스트")
    @Test
    void calculateLottoGameResult() {
        int purchaseAmount = 6000;
        PurchaseAmount purchaseAmountObj = new PurchaseAmount(purchaseAmount);
        List<LottoTicket> tickets = createLottoTickets();
        WinningLottoTicket winningTicket = new WinningLottoTicket(numbers(1, 2, 3, 4, 5, 6), new BonusNumber(7));

        LottoGameResult result = lottoService.draw(tickets, winningTicket);

        Map<Rank, Integer> expectedRanks = Map.of(
                Rank.FIRST, 1, Rank.SECOND, 1, Rank.THIRD, 1,
                Rank.FOURTH, 1, Rank.FIFTH, 1, Rank.MISS, 1);
        assertThat(result.getRankCountMap()).isEqualTo(expectedRanks);

        double expectedYieldValue = 338_592.5;
        assertThat(result.getYield(purchaseAmountObj).getValue()).isEqualTo(expectedYieldValue);
    }

    private List<LottoTicket> createLottoTickets() {
        return List.of(
            new LottoTicket(numbers(1, 2, 3, 4, 5, 6)),   // 1등
            new LottoTicket(numbers(1, 2, 3, 4, 5, 7)),   // 2등
            new LottoTicket(numbers(1, 2, 3, 4, 5, 8)),   // 3등
            new LottoTicket(numbers(1, 2, 3, 4, 9, 10)),  // 4등
            new LottoTicket(numbers(1, 2, 3, 11, 12, 13)), // 5등
            new LottoTicket(numbers(1, 2, 14, 15, 16, 17)) // 낙첨
        );
    }

    private Set<LottoNumber> numbers(final int... values) {
        Set<LottoNumber> lottoNumbers = new TreeSet<>();
        for (int value : values) {
            lottoNumbers.add(new LottoNumber(value));
        }
        return lottoNumbers;
    }

    private Set<LottoNumber> createLottoNumbers(final int... numbers) {
        Set<LottoNumber> lottoNumbers = new TreeSet<>();
        for (int number : numbers) {
            lottoNumbers.add(new LottoNumber(number));
        }
        return lottoNumbers;
    }
    
    @DisplayName("수동 티켓과 자동 티켓 함께 구매 테스트")
    @Test
    void purchaseTicketsWithManualAndAuto() {
        List<LottoTicket> manualTickets = List.of(
            new LottoTicket(numbers(1, 2, 3, 4, 5, 6)),
            new LottoTicket(numbers(10, 20, 30, 40, 41, 42))
        );
        int manualCount = manualTickets.size();
        int totalCount = 5;
        int autoCount = totalCount - manualCount;
        
        TotalTicketCount totalTicketCount = new TotalTicketCount(
            new TicketCount(totalCount), 
            new TicketCount(manualCount)
        );

        List<LottoTicket> allTickets = lottoService.purchaseTickets(manualTickets, totalTicketCount);

        assertThat(allTickets).hasSize(totalCount);
        assertThat(allTickets.subList(0, manualCount)).containsExactlyElementsOf(manualTickets);

        List<LottoTicket> autoTickets = allTickets.subList(manualCount, totalCount);
        assertThat(autoTickets).hasSize(autoCount);
        for (LottoTicket ticket : autoTickets) {
            assertThat(ticket.getNumbers()).hasSize(6);
        }
    }
} 
