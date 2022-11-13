package nextstep.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.function.Supplier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGameFactoryTest {

  @DisplayName("random 생성 룰에 맞게 로또를 생성한다.")
  @Test
  public void spec01() {
    final Lotto sample = new Lotto(1, 2, 3, 4, 5, 6);
    final Supplier<Lotto> sampleLottoGenerator = () -> sample;

    final LottoGameFactory lottoGameFactory = new LottoGameFactory(sampleLottoGenerator);

    assertThat(lottoGameFactory.random()).isEqualTo(sample);
  }

  @DisplayName("LottoRandomGenerator 는 로또를 생성할 수 있다.")
  @Test
  public void spec02() {
    assertThatNoException().isThrownBy(() -> new LottoRandomGenerator().get());
  }
}
