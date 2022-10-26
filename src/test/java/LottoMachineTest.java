import static org.assertj.core.api.Assertions.*;

import domain.lotto.LottoMachine;
import domain.lotto.Lottos;
import domain.strategy.GenerateLottoNum;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import strategy.GenerateLottoNumFixed;

public class LottoMachineTest {

  @Test
  @DisplayName("20장 구매, 5천원 수익시 수익률 계산")
  void checkRevenueRatio() {
    LottoMachine lottoMachine = new LottoMachine();
    float totalPrize = lottoMachine.revenueRatio(20, 5000);
    assertThat(totalPrize).isEqualTo(0.25f);
  }

  @Test
  @DisplayName("0 이하 amount 입력 시 IllegalArgumentException 발생")
  void checkAmountValidation() {
    LottoMachine lottoMachine = new LottoMachine();
    assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(
            () -> {
              lottoMachine.revenueRatio(0, 500);
            }
        );
  }

  @Test
  @DisplayName("3개 일치 3장시 상금 15000원")
  void checkTotalPrize() {
    LottoMachine lottoMachine = new LottoMachine();
    GenerateLottoNum generateLottoNum = new GenerateLottoNumFixed();
    int[] winningnumsArray = {1, 2, 3, 11, 12, 13};
    List<Integer> winningNums = Arrays.stream(winningnumsArray).boxed()
        .collect(Collectors.toList());
    Lottos lottos = lottoMachine.makeLottos(3, generateLottoNum);
    Map<Integer, Integer> prizeMap = lottoMachine.checkPrizes(winningNums, lottos);
    float totalPrize = lottoMachine.calculateTotalPrize(prizeMap);
    assertThat(totalPrize).isEqualTo(15000f);

  }
}
