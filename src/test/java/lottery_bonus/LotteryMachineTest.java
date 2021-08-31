package lottery_bonus;

import lottery_bonus.domain.LotteryMachine;
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

    @Test
    @DisplayName("사이즈가 6인 로또숫자 리스트 생성 테스트")
    void generate() {
        List<Integer> numberList = lotteryMachine.generateLottery();
        assertThat(numberList.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("입력한 티켓 수만큼 로또 발급 테스트")
    void issue(){
        int ticket = 1;
        assertThat(lotteryMachine.issue(ticket)).isNotNull();
    }

    @ParameterizedTest
    @CsvSource(value = {"1000,1", "10000,10"})
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

}
