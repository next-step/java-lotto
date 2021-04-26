package study.step2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.step2.domain.Lottos;
import study.step2.domain.LottosFactory;

public class LottosFactoryTest {

  @DisplayName("구매 금액을 입력 후 복권의 수 만큼  lottos 객체를 셍성하는지 테스트")
  @Test
  void lottosFactory() {
    // given
    int lottoCount = 3;

    // when
    Lottos lottos = LottosFactory.makeLottos(lottoCount);

    // then
    assertThat(lottos).isEqualTo(new Lottos(lottos.getLottos()));
  }

  @DisplayName("구매 금액을 0으로 입력했을 때, lotto 객체 크기가 0인지 테스트")
  @Test
  void lottosFactoryFail() {
    // given
    int lottoCount = 0;

    // when
    Lottos lottos = LottosFactory.makeLottos(lottoCount);

    // then
    assertThat(lottos).isEqualTo(new Lottos(new ArrayList<>()));
  }

}
