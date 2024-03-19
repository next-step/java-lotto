package factory;

import domain.PositiveNumber;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryFactoryTest {
  @ParameterizedTest
  @CsvSource({ "1,1", "3,3", "5,5" })
  void 입력_n_만큼의_로또_생성(int size, int expected) {
    assertThat(LotteryFactory.randomLotteries(PositiveNumber.of(size)).size()).isEqualTo(expected);
  }
}
