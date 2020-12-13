package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoMachineTest {
    
    @Test
    @DisplayName("6개의 로또 번호를 가지는 로또 티켓 한장 생성")
    public void generate() {
        //given
        LottoMachine lottoMachine = new LottoMachine();

        //when
        LottoTicket lottoTicket = lottoMachine.generate();

        //then
        Assertions.assertEquals(6, lottoTicket.numberCount());
    }

    @DisplayName("구입할 개수의 로또를 생성한다")
    @ParameterizedTest
    @CsvSource(value = {"10000,10","15000,15","1000,1"})
    public void manyGenerate(int price, int expected) {
        //given
        Lotto lotto = new Lotto();
        int purchaseQuantity = lotto.purchaseQuantity(price);
        LottoMachine lottoMachine = new LottoMachine();

        //when
        LottoTickets lottoTickets = lottoMachine.generate(purchaseQuantity);
        System.out.println(lottoTickets);

        //then
        Assertions.assertEquals(expected, lottoTickets.lottoTicketCount());
    }
}
