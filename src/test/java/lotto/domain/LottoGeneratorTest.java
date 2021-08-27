package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoGeneratorTest {

  @ParameterizedTest(name = "로또 랜덤생성 테스트: {0}개")
  @ValueSource(ints = {1, 2, 20})
  void generateByRandomTest(int cnt) {
    //when
    List<Lotto> lottos = LottoGenerator.generatedLottosByRandomNumber(cnt);

    //then
    assertThat(lottos.size()).isEqualTo(cnt);
  }

  @ParameterizedTest(name = "로또 랜덤생성 에러테스트: {0}개")
  @ValueSource(ints = {-2, -1, 0})
  void invalidGenerateByRandomTest(int cnt) {
    //then
    assertThatIllegalArgumentException().isThrownBy(() -> {
      LottoGenerator.generatedLottosByRandomNumber(cnt);
    });
  }
}
