package lotto.constants;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class PrizeGradeTest {

  @ParameterizedTest
  @ValueSource(ints = {3, 4, 5, 6})
  void 객체생성_테스트(int matchCount) {
    assertThat(PrizeGrade.of(matchCount) != PrizeGrade.FAIL).isTrue();
  }
}