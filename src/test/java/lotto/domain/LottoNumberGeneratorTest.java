package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class LottoNumberGeneratorTest {

  @DisplayName("중복없는 로또 번호 6개가 반환된다")
  @RepeatedTest(10)
  void generateLottoNumber() {
    LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
    List<Integer> generate = lottoNumberGenerator.generate();
    assertThat(generate).hasSize(6);
    assertThat(generate).doesNotHaveDuplicates();
  }
}
