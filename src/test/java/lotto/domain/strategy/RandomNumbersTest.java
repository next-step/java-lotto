package lotto.domain.strategy;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class RandomNumbersTest {

  @DisplayName("중복없는 로또 번호 6개가 반환된다")
  @RepeatedTest(100)
  void generateLottoNumber() {
    GenerateNumbersStrategy generateNumbersStrategy = new RandomNumbers();
    List<Integer> generate = generateNumbersStrategy.generate();
    assertThat(generate).hasSize(6);
    assertThat(generate).doesNotHaveDuplicates();
    assertThat(generate).hasSizeBetween(1, 45);
  }
}
