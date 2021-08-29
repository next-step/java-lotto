package lottery_auto;

import lottery_auto.domain.LotteryMachine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LotteryMachineTest {

    private final LotteryMachine lotteryMachine = LotteryMachine.getInstance();

    @ParameterizedTest
    @CsvSource(value = {"14000,14", "1000,1"})
    @DisplayName("입력한 금액만큼 티켓 구매 테스트")
    void purchase(BigDecimal amount, int number){

        assertThat(lotteryMachine.purchase(amount)).isEqualTo(number);
    }

    @Test
    @DisplayName("1000원 이하의 금액을 입력시 예외 테스트")
    void purchaseException(){
        BigDecimal amount = new BigDecimal(900);
        assertThatThrownBy(()->lotteryMachine.purchase(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력한 티켓 수만큼 로또 발급 테스트")
    void issue(){
        int ticket = 3;
        assertThat(lotteryMachine.issue(ticket)).isNotNull();
    }

    @Test
    @DisplayName("사이즈가 6인 로또숫자 리스트 생성 테스트")
    void generate() {
        List<Integer> numberList = lotteryMachine.generateNumber();
        assertThat(numberList.size()).isEqualTo(6);
    }

}
