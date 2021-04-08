package step02.code.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class LottosTest {

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
}
