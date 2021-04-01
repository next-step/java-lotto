package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoStoreTest {

  @DisplayName("로또 횟수 구하기")
  @ParameterizedTest
  @CsvSource(value =
      {"1000:1", "1500:1", "2000:2", "2900:2", "5000:5", "8000:8", "8900:8"}, delimiter = ':'
  )
  void count_lotto_try_count(String money, String result) {
    LottoGame lottoGame = LottoStore.sell(Collections.EMPTY_LIST, new Money(Integer.parseInt(money)));
    assertThat(lottoGame.size()).isEqualTo(Integer.parseInt(result));
    LottoGame lottoGame2 = LottoStore.sell(Arrays.asList("1,2,3,4,5,6"), new Money(Integer.parseInt(money)));
    assertThat(lottoGame2.size()).isEqualTo(Integer.parseInt(result));
  }

}