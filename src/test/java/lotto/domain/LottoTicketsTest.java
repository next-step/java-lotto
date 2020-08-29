package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsTest {

    private List<LottoTicket> mockLottoTickets;
    private LottoTicket winningNumber;
    private int bonusNumber;
    private WinningNumber winningNumbers;
    private List<LottoTicket> mockTestLottoTickets;

    @BeforeEach
    void setUp() {
        mockLottoTickets = initMockLottoTickets();
        mockTestLottoTickets = initMockTestLottoTickets();
        winningNumber = new LottoTicket(Arrays.asList(1,2,3,4,5,6));
        bonusNumber = 7;
        winningNumbers = new WinningNumber(winningNumber, bonusNumber);
    }

    private List<LottoTicket> initMockLottoTickets() {
        mockLottoTickets = new ArrayList<>();
        mockLottoTickets.add(new LottoTicket(Arrays.asList(1,2,3,4,5,6)));
        mockLottoTickets.add(new LottoTicket(Arrays.asList(1,2,3,4,10,11)));
        mockLottoTickets.add(new LottoTicket(Arrays.asList(1,2,3,4,5,7)));
        return mockLottoTickets;
    }

    private List<LottoTicket> initMockTestLottoTickets() {
        mockTestLottoTickets = new ArrayList<>();
        mockTestLottoTickets.add(new LottoTicket(Arrays.asList(1,2,3,4,5,6)));
        return mockTestLottoTickets;
    }

    @Test
    @DisplayName("n개의 로또 복권 당첨 확인")
    void matchResult() {
        LottoTickets lottoTickets = new LottoTickets(mockLottoTickets);
        Map<Rank, Long> winningResult = lottoTickets.matchResult(winningNumbers);
        assertThat(winningResult.get(Rank.FIRST)).isEqualTo(1);
        assertThat(winningResult.get(Rank.SECOND)).isEqualTo(1);
        assertThat(winningResult.get(Rank.FOURTH)).isEqualTo(1);
    }

    @Test
    @DisplayName("정적 팩토리 메소드")
    void staticFactoryMethod() {
        LottoTickets lottoTickets = LottoTickets.of(mockLottoTickets, mockTestLottoTickets);
        assertThat(lottoTickets.size()).isEqualTo(4);
    }

}
