package factory;

import lotto.domain.PositiveNumber;
import lotto.factory.LottoFactory;
import lotto.factory.RandomFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoFactoryTest {
  @ParameterizedTest
  @CsvSource({ "1,1", "3,3", "5,5" })
  void 입력_n_만큼의_로또_생성(int size, int expected) {
    LottoFactory lottoFactory = new LottoFactory(new RandomFactory(new Random()));
    assertThat(lottoFactory.randomLottos(PositiveNumber.of(size)).size()).isEqualTo(expected);
  }
}
