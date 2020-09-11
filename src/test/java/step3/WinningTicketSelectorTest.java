package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.WinningTicketSelector;

import static org.assertj.core.api.Assertions.*;

public class WinningTicketSelectorTest {

    @DisplayName("6개 아닌 갯수 입력시 오류 테스트")
    @Test
    void numberCountTest(){
        WinningTicketSelector winningTicketSelector = new WinningTicketSelector("1,2,3,4,5,6" ,1);

        assertThatIllegalArgumentException().isThrownBy(()->{
            WinningTicketSelector selector = new WinningTicketSelector("1,2,3,4,5,6,7", 1);
        });
    }

    @DisplayName("보너스 번호 validation 테스")
    @Test
    void winningNumbersTest(){

        assertThatIllegalArgumentException().isThrownBy(()->{
            WinningTicketSelector winningTicketSelector = new WinningTicketSelector("1,2,3,4,5,6" ,46);
        });

    }
}
