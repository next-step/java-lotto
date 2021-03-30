package step02.code.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottosTest {

  @Test
  @DisplayName("lotto 최소 구매 금액 이하인경우, lotto 구입후 잔액이 남은경우 error")
  public void check() {
    assertThatThrownBy(() -> {
      // 로또 최소 구매 금액 이하인경우
      Lottos.buy(500);
    }).isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> {
      // 로또 구매후 잔액이 남는 경우
      Lottos.buy(1500);
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @RepeatedTest(value = 100)
  @DisplayName("lotto 생성시, 최소값 1, 최대값 45 안의 6자리 숫자가 생성확인")
  public void lottoNumber() {
    List<Number> lotto = new Lotto(new RandomNumber()).lotto();
    int min = lotto.stream().map(Number::number).min(Integer::compare).orElse(-1);
    int max = lotto.stream().map(Number::number).max(Integer::compare).orElse(46);

    assertThat(lotto.size()).isEqualTo(6);
    assertThat(min).isGreaterThan(0);
    assertThat(max).isLessThan(46);
  }

  @ParameterizedTest
  @CsvSource(value = {"1000:1", "15000:15"}, delimiter = ':')
  @DisplayName("구매 금액에 맞춰서 정확한 갯수의 lotto 가 생성확인")
  public void buy(int money, int number) {
    List<Lotto> lottos = Lottos.buy(money).lottos();

    assertThat(lottos.size()).isEqualTo(number);
  }
}
