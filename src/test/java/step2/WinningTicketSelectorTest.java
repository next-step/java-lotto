package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.LottoTicket;
import step2.domain.WinningTicketSelector;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class WinningTicketSelectorTest {

    private WinningTicketSelector  winningTicketSelector = new WinningTicketSelector("1,2,3,4,5,6");

    @DisplayName("당첨 번호가 생성 되는지 테스트")
    @Test
    void winningNumbersTest(){
        assertThat(winningTicketSelector.getWinningNumbers().size()).isEqualTo(6);
    }

    @DisplayName("로또티켓 검사하여 같은 번호 갯수 체크 테스트")
    @Test
    void checkWinningNumberCountTest(){
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(10);

        LottoTicket ticket = new LottoTicket(numbers);
        assertThat(winningTicketSelector.checkWinningNumberCount(ticket)).isEqualTo(5);
    }

}
