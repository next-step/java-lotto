package Lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottonMachineTest {

    @Test
    @DisplayName("가격을 입력했을 때 사용자가 구매한 로또의 개수 반환")
    public void calculate_purchaseNum(){
        int purchaseNum = LottoMachine.calculatePurchaseNum(14000);
        Assertions.assertThat(purchaseNum).isEqualTo(14);
    }

    @Test
    @DisplayName("알맞지 않은 가격을 입력했을 때 exception")
    public void calculate_Invalid_purchaseNum(){

        Assertions.assertThatIllegalStateException().isThrownBy(
                ()->{LottoMachine.calculatePurchaseNum(140);}
        );
    }

    @Test
    @DisplayName("티켓발권을 제대로 했는지 확인")
    public void ticketingLotto(){
        List<Lotto> lottos = LottoMachine.ticketingLotto(3);
        Assertions.assertThat(lottos.size()).isEqualTo(3);
    }
}
