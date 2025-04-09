package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.WinningLottoTicket;
import lotto.factory.LottoFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoFactoryTest {
    @Test
    @DisplayName("팩토리가 입력 문자열로부터 입력된 문자열 번호와 동일한 LottoTicket들을 생성한다")
    void createTickets(){
        List<String> inputs = List.of("1,2,3,4,5,6", "7,8,9,10,11,12");
        List<LottoTicket> tickets = new ArrayList<>();
        tickets.add(LottoFactory.createLottoTicket("1,2,3,4,5,6"));
        tickets.add(LottoFactory.createLottoTicket("7,8,9,10,11,12"));
        assertThat(LottoFactory.createTickets(inputs).getLottoTickets()).isEqualTo(tickets);
    }

    @Test
    @DisplayName("팩토리가 입력 문자열로부터 입력된 문자열 번호와 동일한 WinningLottoTicket을 생성한다")
    void createWinningTickets(){
        assertThat(LottoFactory.createWinningLottoTicket("1,2,3,4,5,6", 7))
                .isEqualTo(new WinningLottoTicket(LottoFactory.createLottoTicket("1, 2, 3, 4, 5, 6").getLottoTicket(), LottoNumber.of(7)));
    }
}
