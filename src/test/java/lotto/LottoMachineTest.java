package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class LottoMachineTest {
    private static LottoMachine lottoMachine;

    @BeforeAll
    static void beforeAll() {
        lottoMachine = new LottoMachine();
    }

    @Test
    @DisplayName("6개의 로또 번호를 가지는 로또 티켓 한장 생성")
    public void generate() {
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
        Lotto lotto = new Lotto(price);
        int purchaseQuantity = lotto.purchaseQuantity();

        //when
        LottoTickets lottoTickets = lottoMachine.generate(purchaseQuantity);

        //then
        Assertions.assertEquals(expected, lottoTickets.lottoTicketCount());
    }

    @Test
    @DisplayName("당첨 번호를 생성한다")
    public void winningNumber() {
        //given
        String winningNumberString = "1, 2, 3, 4, 5, 6";

        //when
        WinningNumber winningNumber = lottoMachine.winningNumber(winningNumberString);

        //then
        for (int i = 1; i <= 6; i++) {
            assertThat(winningNumber.contains(new LottoNumber(i))).isTrue();
        }
    }
}
