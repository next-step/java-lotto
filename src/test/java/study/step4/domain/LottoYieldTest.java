package study.step4.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("수익 통계")
class LottoYieldTest {

    private String inputNumbers;
    private int inputBonus;

    @BeforeEach
    public void setUp() {
        inputNumbers = "1,2,3,4,5,6";
        inputBonus = 45;
    }

    public LottoTickets createTickets() {
        List<LottoTicket> lottoTickets = Arrays.asList(LottoMachine.createLottoTicket(inputNumbers));
        return new LottoTickets(lottoTickets);
    }

    public LottoWinners createWinners(String winners, int bonus) {
        return LottoMachine.createWinners(winners, bonus);
    }

    @Test
    @DisplayName("수익 통계 일치 테스트")
    void 수익_통계_일치_테스트() {
        LottoTickets tickets = createTickets();
        LottoWinners winners = createWinners("1,2,3,14,15,16", inputBonus);
        double profit = 5.0;

        assertThat(LottoYield.operationYield(tickets, winners)).isEqualTo(profit);
    }
}