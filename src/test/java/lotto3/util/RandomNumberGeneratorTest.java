package lotto3.util;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

  @Test
  void 랜덤번호_생성시_중복없는_번호로_구성_검증() {
    List<Integer> randomNumbers = RandomNumberGenerator.generate();
    int expectedSize = randomNumbers.size();

    Set<Integer> setOfNumbers = randomNumbers.stream().collect(Collectors.toSet());
    int actualSize = setOfNumbers.size();

    assertThat(actualSize).isEqualTo(expectedSize);
  }
}