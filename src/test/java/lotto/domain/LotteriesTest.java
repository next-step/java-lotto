package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LotteriesTest {

  @DisplayName("입력 갯수만큼 로또 생성 테스트.")
  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3, 4})
  void 입력한만큼로또생성(int count) {

    Lotteries lotteries = new Lotteries(count);

    assertThat(lotteries.getLottos().size()).isEqualTo(count);
  }

}