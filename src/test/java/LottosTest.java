import domain.lotto.Lottos;
import domain.strategy.GenerateLottoNum;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import strategy.GenerateLottoNumFixed;

public class LottosTest {

  @Test
  @DisplayName("로또 5장 구매시 로또의 개수가 5개인지 확인")
  void checkLottosSize() {
    GenerateLottoNum generateLottoNum = new GenerateLottoNumFixed();
    Lottos lottos = new Lottos(5, generateLottoNum);
    Assertions.assertThat(lottos.lottos.size()).isEqualTo(5);
  }
}
