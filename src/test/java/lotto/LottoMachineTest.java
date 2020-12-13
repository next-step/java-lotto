package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoMachineTest {
    
    @Test
    @DisplayName("6개의 로또 번호를 가지는 로또 티켓 한장 생성")
    public void generate() {
        //given
        LottoMachine lottoMachine = new LottoMachine();

        //when
        LottoTicket lottoTicket = lottoMachine.generate();
        System.out.println(lottoTicket);
        
        //then
        Assertions.assertEquals(6, lottoTicket.numberCount());
    }
}
