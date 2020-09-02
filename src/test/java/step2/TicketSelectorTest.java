package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.LottoTicket;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

public class LottoTicketTest {

    LottoTicket lotto = new LottoTicket();

    @DisplayName("1 ~ 45 에 대한 정해진 로또 번호들을 담은 컬렉션이 생성 되는지 테스트")
    @Test
    void getLottoNumbersTest(){
        assertThat(lotto.getLottoNumbers().size()).isEqualTo(45);
    }

    @DisplayName("입력받은 총액에 따라 가능한 로또 횟수 계산 테스트")
    @Test
    void calculateAvailableCountTest(){
        int amount = 14900;
        assertThat(lotto.calculateAvailableCount(amount)).isEqualTo(14);
    }

    @DisplayName("로또 티켓 한 장 구매시 로또 번호가 원하는 갯수 만큼 생성 되는지 테스트")
    @Test
    void buySingleLottoTicket(){
        List<Integer> lottoTicket = lotto.buySingleLottoTicket();
        assertThat(lottoTicket.size()).isEqualTo(6);
    }

    @DisplayName("로또 티켓 한 장 구매시 로또 번호가 랜덤하게 생성 되는지 테스트")
    @Test
    void buySingleLottoTicketRandomTest(){
        List<Integer> firstLottoTicket = lotto.buySingleLottoTicket();
        List<Integer> secondLottoTicket = lotto.buySingleLottoTicket();

        assertThat(firstLottoTicket.equals(secondLottoTicket)).isFalse();
    }

    @DisplayName("주어진 금액 내에서 최대치의 로또 티켓이 구매 되는지 테스트")
    @Test
    void buyAvailableLottoTicketsTest(){
        lotto.buyAvailableLottoTickets(lotto.calculateAvailableCount(14900));
        assertThat(lotto.getLottoTickets().size()).isEqualTo(14);
    }

}
