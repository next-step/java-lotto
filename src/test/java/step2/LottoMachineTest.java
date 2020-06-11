package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 머신 클래스 테스트")
class LottoMachineTest {

    @Test
    @DisplayName("숫자를 입력하면 로또 숫자만큼 나오는 테스트")
    void getLottoNumbersListTest() {
        int lottoCount = 3;
        LottoMachine machine = new LottoMachine();
        List<LottoTicket> lottoTicketList = machine.extractLottoTicketsByCount(lottoCount);

        assertThat(lottoTicketList).hasSize(lottoCount);
    }

    @Test
    @DisplayName("로또 숫자의 정렬되었는지 테스트")
    void checkSortedlottoNumbersTest() {

        LottoMachine machine = new LottoMachine();
        List<LottoTicket> oneLottoTicket = machine.extractLottoTicketsByCount(1);

        List<Integer> lotteryNumberList = oneLottoTicket.get(0).getNumbers();
        int comparedNumber = 0;
        for (Integer lottoNumber : lotteryNumberList) {
            assertThat(comparedNumber).isLessThan(lottoNumber);
            comparedNumber = lottoNumber;
        }
    }

    @Test
    @DisplayName("맞춤 갯수가 몇개인지 확인하는 테스트")
    void 숫자_몇개_맞췄나() {
        LottoTicket winningNumbers = LottoTicket.makeLottoTicket(Arrays.asList(1, 2, 3, 4, 9, 10));
        LottoTicket lottoTicket = LottoTicket.makeLottoTicket(Arrays.asList(1,2,3,4,5,6));

        LottoMachine machine = new LottoMachine();
        List<Integer> winningCountList = machine.checkLottoWinning(winningNumbers, Collections.singletonList(lottoTicket));

        assertThat(4).isEqualTo(winningCountList.get(0));
    }
}