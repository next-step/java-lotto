package step02.code.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class GradeEnumTest {
  @ParameterizedTest
  @MethodSource("gradeTestCase")
  @DisplayName("보너스 숫자가 맞을때 2등, 틀릴때 3등 return")
  public void grade(int matched, boolean isMatchBonus, GradeEnum grade) {
    GradeEnum gradeEnum = GradeEnum.fromGrade(matched, isMatchBonus);

    assertThat(gradeEnum).isEqualTo(grade);
  }

  private static Stream<Arguments> gradeTestCase() {
    return Stream.of(
      Arguments.of(6, false, GradeEnum.FIRST),
      Arguments.of(5, true, GradeEnum.SECOND),
      Arguments.of(5, false, GradeEnum.THIRD),
      Arguments.of(4, false, GradeEnum.FOURTH),
      Arguments.of(3, false, GradeEnum.FIFTH)
    );
  }

  @Test
  @DisplayName("enum list 순서 상금 역순으로 return / NONE 제외")
  public void sorted() {
    List<GradeEnum> list = GradeEnum.sorted();
    
    assertThat(list.get(0)).isEqualTo(GradeEnum.FIFTH);
    assertThat(list.get(list.size() - 1)).isEqualTo(GradeEnum.FIRST);
  }
}
