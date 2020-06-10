package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 머신 클래스 테스트")
class LottoMachineTest {

    @Test
    @DisplayName("숫자를 입력하면 로또 숫자만큼 나오는 테스트")
    void getLottoNumbersListTest() {
        int lottoCount = 3;
        LottoMachine lottery = new LottoMachine();
        List<LottoTicket> lottoTicketList = lottery.extractLottoTicketsByCount(lottoCount);

        assertThat(lottoTicketList).hasSize(lottoCount);
    }

    @Test
    @DisplayName("로또 숫자의 정렬되었는지 테스트")
    void checkSortedlottoNumbersTest() {

        LottoMachine lottery = new LottoMachine();
        List<LottoTicket> oneLottoTicket = lottery.extractLottoTicketsByCount(1);

        List<Integer> lotteryNumberList = oneLottoTicket.get(0).getNumbers();
        int comparedNumber = 0;
        for (Integer lottoNumber : lotteryNumberList) {
            assertThat(comparedNumber).isLessThan(lottoNumber);
            comparedNumber = lottoNumber;
        }
    }
}