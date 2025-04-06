package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.factory.ManualLottoFactory;
import lotto.strategy.ManualLottoStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ManualLottoTest {
    @Test
    @DisplayName("로또 수동 생성시 입력받은 로또 번호와 동일한 번호로 로또를 생성한다.")
    void manualLottoStrategy(){
        LottoTicket lottoTicket = new LottoTicket("1,2,3,4,5,6");
        ManualLottoStrategy strategy = new ManualLottoStrategy(new LottoTicket("1,2,3,4,5,6"));
        assertThat(strategy.generateLottoNumbers()).isEqualTo(lottoTicket.getLottoTicket());
    }

    @Test
    @DisplayName("팩토리가 입력 문자열로부터 입력된 문자열 번호와 동일한 LottoTicket들을 생성한다")
    void createTickets(){
        List<String> inputs = List.of("1,2,3,4,5,6", "7,8,9,10,11,12");
        List<LottoTicket> tickets = new ArrayList<>();
        tickets.add(new LottoTicket("1,2,3,4,5,6"));
        tickets.add(new LottoTicket("7,8,9,10,11,12"));
        assertThat(ManualLottoFactory.createTickets(inputs).getLottoTickets()).isEqualTo(tickets);
    }
}
