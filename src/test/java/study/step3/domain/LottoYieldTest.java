package study.step3.domain;

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
        LottoQuantity lottoQuantity = new LottoQuantity(5000);
        List<LottoTicket> lottoTickets = Arrays.asList(LottoMachine.createLottoTicket(inputNumbers));
        return new LottoTickets(lottoQuantity, lottoTickets);
    }

    public LottoWinners createWinners(String winners, int bonus) {
        return LottoMachine.createWinners(winners, bonus);
    }

    @Test
    @DisplayName("수익 통계 일치 테스트")
    void 수익_통계_일치_테스트() {
        LottoTickets tickets = createTickets();
        LottoWinners winners = createWinners("1,2,3,14,15,16", inputBonus);
        double profit = 1;

        assertThat(LottoYield.operationYield(tickets, winners)).isEqualTo(profit);
    }

    @Test
    @DisplayName("이익 문자열 테스트")
    void 이익_문자열_테스트() {
        LottoTickets tickets = createTickets();
        LottoWinners winners = createWinners("1,2,3,4,15,16", inputBonus);
        String result = "이익";

        double profit = LottoYield.operationYield(tickets, winners);

        assertThat(LottoYield.stringYield(profit)).isEqualTo(result);
    }

    @Test
    @DisplayName("손해 문자열 테스트")
    void 손해_문자열_테스트() {
        LottoTickets tickets = createTickets();
        LottoWinners winners = createWinners("1,2,13,14,15,16", inputBonus);
        String result = "손해";

        double profit = LottoYield.operationYield(tickets, winners);

        assertThat(LottoYield.stringYield(profit)).isEqualTo(result);
    }
}