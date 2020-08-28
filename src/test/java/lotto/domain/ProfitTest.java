package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ProfitTest {

    private List<LottoTicket> mockLottoTickets;
    private LottoTicket winningNumber;
    private int bonusNumber;
    private WinningNumber winningNumbers;
    private Profit profit;
    private WinningResult winningResult;

    @BeforeEach
    void setUp() {
        mockLottoTickets = initMockLottoTickets();
        winningNumber = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        bonusNumber = 7;
        winningNumbers = new WinningNumber(winningNumber, bonusNumber);

        LottoTickets lottoTickets = new LottoTickets(mockLottoTickets);
        winningResult = lottoTickets.matchResult(winningNumbers);
        profit = new Profit(winningResult);
    }

    private List<LottoTicket> initMockLottoTickets() {
        mockLottoTickets = new ArrayList<>();
        mockLottoTickets.add(new LottoTicket(Arrays.asList(1, 2, 3, 4, 20, 26)));
        mockLottoTickets.add(new LottoTicket(Arrays.asList(1, 2, 3, 4, 10, 11)));
        mockLottoTickets.add(new LottoTicket(Arrays.asList(1, 2, 3, 15, 35, 37)));
        return mockLottoTickets;
    }

    @Test
    @DisplayName("당첨 금액 확인")
    void checkTheWinningAmount() {
        int result = profit.getWinningAmount();
        assertThat(result).isEqualTo(105_000);
    }

    @ParameterizedTest
    @DisplayName("수익률 확인")
    @CsvSource(value = {"14000:5000:0.35", "20000:5000:0.25", "1000:50000:50.00"}, delimiter = ':')
    void rateOfReturn(int price, int winningAmount, String expected) {
        String result = profit.getRateOfReturn(price, winningAmount);
        assertThat(result).isEqualTo(expected);
    }

}
