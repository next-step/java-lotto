import domain.Lottos;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {

  @Test
  @DisplayName("로또 5장 구매시 로또의 개수가 5개인지 확인")
  void checkLottosSize() {
    Lottos lottos = new Lottos(5);
    Assertions.assertThat(lottos.lottos.size()).isEqualTo(5);
  }
}
