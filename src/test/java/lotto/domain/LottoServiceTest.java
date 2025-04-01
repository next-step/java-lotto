package lotto.domain;

import lotto.domain.model.game.LottoGameResult;
import lotto.domain.model.lotto.PurchaseAmount;
import lotto.domain.model.game.Rank;
import lotto.domain.model.game.Yield;
import lotto.domain.model.lotto.BonusNumber;
import lotto.domain.model.lotto.LottoNumber;
import lotto.domain.model.lotto.LottoTicket;
import lotto.domain.model.lotto.WinningLottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoServiceTest {

    private final LottoService lottoService = new LottoService();

    @DisplayName("로또 티켓 구매 테스트")
    @Test
    void purchaseTickets() {
        int purchaseAmount = 5000;

        List<LottoTicket> tickets = lottoService.purchaseTickets(purchaseAmount);

        assertThat(tickets).hasSize(5);
        for (LottoTicket ticket : tickets) {
            assertThat(ticket.getNumbers()).hasSize(6);
        }
    }

    @DisplayName("로또 티켓 구매 수량 계산 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 5000, 10000})
    void calculateTicketCount(int purchaseAmount) {
        List<LottoTicket> tickets = lottoService.purchaseTickets(purchaseAmount);

        int expectedCount = purchaseAmount / 1000;
        assertThat(tickets).hasSize(expectedCount);
    }

    @DisplayName("로또 티켓 구매 금액 검증 테스트")
    @ParameterizedTest
    @ValueSource(ints = {0, -1000})
    void validateInvalidPurchaseAmount(int invalidAmount) {
        assertThatThrownBy(() -> lottoService.purchaseTickets(invalidAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구입 금액은 0보다 커야 합니다");
    }

    @DisplayName("당첨 로또 티켓 생성 테스트")
    @Test
    void createWinningTicket() {
        Set<LottoNumber> winningNumbers = createLottoNumbers(1, 2, 3, 4, 5, 6);
        BonusNumber bonusNumber = new BonusNumber(7);

        WinningLottoTicket winningTicket = lottoService.createWinningTicket(winningNumbers, bonusNumber);

        assertThat(winningTicket.getNumbers()).containsExactlyInAnyOrderElementsOf(winningNumbers);
        assertThat(winningTicket.getBonusNumber()).isEqualTo(bonusNumber);
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
} 
