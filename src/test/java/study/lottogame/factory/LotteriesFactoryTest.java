package study.lottogame.factory;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import study.lottogame.domain.Money;

public class LotteriesFactoryTest {

  @DisplayName("(돈/1000) 개의 자동 로또들을 생성한다.")
  @ParameterizedTest
  @ValueSource(ints = {0, 100, 1000, 1500, 2000, 10000})
  public void create_lotteries(int input) {
    assertThat(LotteriesFactory.create(new Money(input)).getLotteries()).hasSize(input / 1000);
  }

}
