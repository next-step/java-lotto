package factory;

import lotto.domain.PositiveNumber;
import lotto.factory.RandomFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Random;

import static org.assertj.core.api.Assertions.*;

public class RandomFactoryTest {
  @ParameterizedTest
  @CsvSource({ "1,1", "3,3", "5,5" })
  void 입력_n_만큼의_숫자_생성(int size, int expected) {
    RandomFactory randomFactory = new RandomFactory(new Random());
    assertThat(randomFactory.randomNumbers(PositiveNumber.of(size)).size()).isEqualTo(expected);
  }

  @Test
  void 캐싱된_객체_반환() {
    RandomFactory randomFactory = new RandomFactory(new Random()) {
      @Override
      protected int cacheIndex() {
        return 5;
      }
    };

    assertThat(randomFactory.randomNumber()).isSameAs(randomFactory.randomNumber());
  }
}
