package domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import view.InputView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoMachineTest {
    private static LottoMachine lottoMachine;

    @BeforeAll
    static void beforeAll() {
        lottoMachine = new LottoMachine();
    }


    @DisplayName("구입 할 수 있는 로또의 개수를 구한다")
    @ParameterizedTest
    @CsvSource(value = {"10000,10","15000,15","1000,1"})
    public void buyLottos(int price, int expected) throws Exception {
        //when
        int purchaseQuantity = lottoMachine.purchaseQuantity(price);

        //then
        assertThat(expected).isEqualTo(purchaseQuantity);
    }

    @Test
    @DisplayName("1000원 미만의 금액으로 로또를 구매하려고 하면 오류")
    public void purchasePriceLimit() {
        //given
        int price = 990;

        //when then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> lottoMachine.purchaseQuantity(price))
                .withMessageMatching("1000원 이상의 금액을 입력해야 합니다.");
    }

    @Test
    @DisplayName("6개의 로또 번호를 가지는 로또 티켓 한장 생성")
    public void generate() {
        //when
        LottoTicket lottoTicket = lottoMachine.generate();

        //then
        assertThat(6).isEqualTo(lottoTicket.numberCount());
    }

    @DisplayName("구입할 개수의 로또를 생성한다")
    @ParameterizedTest
    @CsvSource(value = {"10000,10","15000,15","1000,1"})
    public void manyGenerate(int price, int expected) {
        //when
        LottoTickets lottoTickets = lottoMachine.generate(price);

        //then
        assertThat(expected).isEqualTo(lottoTickets.lottoTicketCount());
    }

    @Test
    @DisplayName("당첨 번호를 생성한다")
    public void winningNumber() {
        //given
        String winningNumberString = "1, 2, 3, 4, 5, 6";

        //when
        WinningNumber winningNumber = InputView.winningNumber(winningNumberString);

        //then
        for (int i = 1; i <= 6; i++) {
            assertThat(winningNumber.contains(new LottoNumber(i))).isTrue();
        }
    }

    @DisplayName("당첨 번호에 속한 번호가 보너스 볼로 생성될 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6})
    public void bonusBallIsNotContains(int bonusNumber) {
        //given
        String winningNumberString = "1, 2, 3, 4, 5, 6";
        WinningNumber winningNumber = InputView.winningNumber(winningNumberString);

        //when then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> InputView.bonusBall(bonusNumber, winningNumber))
                .withMessageMatching("보너스 볼은 당첨 번호들이랑 달라야 합니다.");
    }
}
