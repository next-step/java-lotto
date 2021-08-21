package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoGeneratorTest {

  @ParameterizedTest(name = "로또 생성 테스트: {0}개")
  @ValueSource(ints = {1, 2, 20})
  void generateTest(int cnt) {
    //when
    List<Lotto> lottos = LottoGenerator.generate(cnt);

    //then
    assertThat(lottos.size()).isEqualTo(cnt);
  }

  @ParameterizedTest(name = "로또 생성 에러테스트: {0}개")
  @ValueSource(ints = {-2, -1, 0})
  void invalidGenerateTest(int cnt) {
    //then
    assertThatIllegalArgumentException().isThrownBy(() -> {
      LottoGenerator.generate(cnt);
    });
  }
}
