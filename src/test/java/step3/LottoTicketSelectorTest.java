package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.LottoTicket;
import step3.domain.LottoTicketSelector;

import static org.assertj.core.api.Assertions.*;

public class LottoTicketSelectorTest {

    @DisplayName("생성 후 로또 번호 POOL 생성 되는지 테스트")
    @Test
    void LottoTicketSelectorConstructorTest(){
        int testAmount = 1000;
        LottoTicketSelector lottoTicketSelector = new LottoTicketSelector(testAmount);

        assertThat(lottoTicketSelector.getLottoNumberPool().size()).isEqualTo(45);

    }

    @DisplayName("입력받은 총액에 따라 가능한 로또 횟수 계산 테스트")
    @Test
    void calculateAvailableCountTest(){
        int testAmount = 14900;
        LottoTicketSelector lottoTicketSelector = new LottoTicketSelector(testAmount);

        assertThat(lottoTicketSelector.calculateAvailableTicketCount()).isEqualTo(14);
    }


    @DisplayName("로또 티켓 한 장 구매시 로또 번호가 원하는 갯수 만큼 생성 되는지 테스트")
    @Test
    void buySingleLottoTicket(){
        int testAmount = 14900;
        LottoTicketSelector lottoTicketSelector = new LottoTicketSelector(testAmount);

        LottoTicket lottoTicket = lottoTicketSelector.buySingleAutoLottoTicket();
        assertThat(lottoTicket.getLottoNumbers().size()).isEqualTo(6);
    }

    @DisplayName("로또 티켓 한 장 구매시 로또 번호가 랜덤하게 생성 되는지 테스트")
    @Test
    void buySingleLottoTicketRandomTest(){
        int testAmount = 14900;
        LottoTicketSelector lottoTicketSelector = new LottoTicketSelector(testAmount);

        LottoTicket firstLottoTicket = lottoTicketSelector.buySingleAutoLottoTicket();
        LottoTicket secondLottoTicket = lottoTicketSelector.buySingleAutoLottoTicket();

        assertThat(firstLottoTicket.getLottoNumbers().equals(secondLottoTicket.getLottoNumbers())).isFalse();
    }

    @DisplayName("수동 로또 티켓 구매시 숫자 범위 체크")
    @Test
    void buySingleManualLottoTicket(){
        int testAmount = 14900;
        LottoTicketSelector lottoTicketSelector = new LottoTicketSelector(testAmount);

        assertThatIllegalArgumentException().isThrownBy(()->{
            lottoTicketSelector.buySingleManualLottoTicket("1,2,3,4,5,46");
        });

    }

}
