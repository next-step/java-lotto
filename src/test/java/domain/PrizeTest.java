package domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class PrizeTest {
  @ParameterizedTest
  @CsvSource({ "0,NONE", "1,NONE", "2,NONE", "3,FORTH", "4,THIRD", "5,SECOND", "6,FIRST"})
  void Prize_생성자_테스트(int matchCount, Prize expected) {
    assertThat(Prize.of(new Result(PositiveNumber.of(matchCount)))).isEqualTo(expected);
  }
}
