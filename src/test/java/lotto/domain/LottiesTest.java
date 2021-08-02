package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.strategy.GenerateLottoNumber;
import lotto.strategy.TestGenerateLottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottiesTest {

  @DisplayName("입력 갯수만큼 로또 생성 테스트.")
  @ParameterizedTest
  @ValueSource(ints = {1,2,3,4})
  void 입력한만큼로또생성(int count) {
    Lotties lotties = new Lotties();

    GenerateLottoNumber generateLottoNumber = new TestGenerateLottoNumber(1,7);
    lotties.createLotties(count,generateLottoNumber);

    assertThat(lotties.getLotties().size()).isEqualTo(count);
  }
}