import domain.LottoMachine;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoMachineTest {

  @Test
  @DisplayName("20장 구매, 5천원 수익시 수익률 계산")
  void checkRevenueRatio() {
    LottoMachine lottoMachine = new LottoMachine();
    float totalPrize = lottoMachine.revenueRatio(20,5000);
    Assertions.assertThat(totalPrize).isEqualTo(0.25f);
  }

  @Test
  @DisplayName("0 이하 amount 입력 시 IllegalArgumentException 발생")
  void checkAmountValidation() {
    LottoMachine lottoMachine = new LottoMachine();
    Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(
            () -> {
              lottoMachine.revenueRatio(0,500);
            }
        );
  }
}
