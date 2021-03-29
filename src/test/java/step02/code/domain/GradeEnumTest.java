package step02.code.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GradeEnumTest {
  @Test
  @DisplayName("보너스 숫자가 맞을때 2등, 틀릴때 3등 return")
  public void secondOrThird() {
    GradeEnum second = GradeEnum.fromGrade(5, true);
    GradeEnum third = GradeEnum.fromGrade(5, false);

    assertThat(second).isEqualTo(GradeEnum.SECOND);
    assertThat(third).isEqualTo(GradeEnum.THIRD);
  }
}
