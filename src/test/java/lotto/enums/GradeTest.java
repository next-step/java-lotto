package lotto.enums;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GradeTest {

  @Test
  @DisplayName("로또 2등 테스트")
  void second() {
    Grade second = Grade.SECOND;
    assertThat(second.isSecond()).isTrue();
  }

  @ParameterizedTest
  @DisplayName("로또 결과를 테스트한다.")
  @CsvSource(value = {"6,true:FIRST",
                      "6,false:FIRST",
                      "5,true:SECOND",
                      "5,false:THIRD",
                      "0,false:NONE"},delimiter = ':')
  void valueOf(String input, String output) {
    String[] gradeInput = input.split(",");
    int countOfMatch = Integer.parseInt(gradeInput[0]);
    boolean matchBonus = Boolean.parseBoolean(gradeInput[1]);
    Grade grade = Grade.valueOf(countOfMatch, matchBonus);
    assertThat(grade).isEqualTo(Grade.valueOf(output));
  }
}