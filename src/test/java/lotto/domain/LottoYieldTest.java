package lotto.domain;

import lotto.view.InputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

@DisplayName("수익 통계")
public class LottoYieldTest {

    private List<Integer> inputNumbers;
    private int inputBonus;

    public List<Integer> stringToIntegers(String input) {
        return InputView.stringToIntegers(input);
    }

    @BeforeEach
    public void setUp() {
        inputNumbers = Arrays.asList(1,2,3,4,5,6);
        inputBonus = 45;
    }

    public LottoTickets createTickets() {
        List<LottoTicket> lottoTickets = Arrays.asList(new LottoTicket(inputNumbers));
        return new LottoTickets(lottoTickets);
    }

    public LottoWinners createWinners(List<Integer> winners, int bonus) {
        return LottoMachine.createWinners(winners, bonus);
    }


    @Test
    @DisplayName("수익 통계 일치 테스트")
    public void lottoYieldTrueTest() throws Exception {
        //given
        LottoTickets tickets = createTickets();
        LottoWinners winners = createWinners(stringToIntegers("1,2,3,14,15,16"), inputBonus);
        double profit = 5;

        //when

        //then
        assertThat(LottoYield.operationYield(tickets, winners)).isEqualTo(profit);
    }

    @Test
    @DisplayName("이익 문자열 테스트")
    public void stringProfitTest() throws Exception {
        //given
        LottoTickets tickets = createTickets();
        LottoWinners winners = createWinners(stringToIntegers("1,2,3,4,15,16"), inputBonus);
        String result = "이익";

        //when
        double profit = LottoYield.operationYield(tickets, winners);

        //then
        assertThat(LottoYield.stringYield(profit)).isEqualTo(result);
    }

    @Test
    @DisplayName("손해 문자열 테스트")
    public void stringLossTest() throws Exception {
        //given
        LottoTickets tickets = createTickets();
        LottoWinners winners = createWinners(stringToIntegers("1,2,13,14,15,16"), inputBonus);
        String result = "손해";

        //when
        double profit = LottoYield.operationYield(tickets, winners);

        //then
        assertThat(LottoYield.stringYield(profit)).isEqualTo(result);
    }
}
