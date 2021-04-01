package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoStoreTest {

  @DisplayName("수동입력 없이 자동 게임 횟수 구하기")
  @ParameterizedTest
  @CsvSource(value =
      {"1000:1", "1500:1", "2000:2", "2900:2", "5000:5", "8000:8", "8900:8"}, delimiter = ':'
  )
  void count_lotto_try_count(String money, String result) {
    LottoGame lottoGame = LottoStore.sell(0, new Money(Integer.parseInt(money)));
    assertThat(lottoGame.size()).isEqualTo(Integer.parseInt(result));
  }

  @Test
  void given_manualTryCount_auto_try_count() {
    LottoGame lottoGame = LottoStore.sell(1, new Money(10000));
    assertThat(lottoGame.size()).isEqualTo(9);
  }

}