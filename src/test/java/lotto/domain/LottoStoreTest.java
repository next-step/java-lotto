package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoStoreTest {

  @DisplayName("로또 게임 횟수 구하기")
  @ParameterizedTest
  @CsvSource(value =
      {"1000:1","1500:1","2000:2","2900:2","5000:5","8000:8","8900:8"}, delimiter = ':'
  )
  void count_lotto_try_count(String money, String result) {
    LottoStore lottoStore = new LottoStore();
    List<LottoGame> sell = lottoStore.sell(new Money(Integer.parseInt(money)));
    assertThat(sell.size()).isEqualTo(Integer.parseInt(result));
  }

}