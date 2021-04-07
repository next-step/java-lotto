package step02.code.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GradeEnumTest {
  @ParameterizedTest
  @CsvSource(value = {
    "6:false:FIRST",
    "5:true:SECOND",
    "5:false:THIRD",
    "4:false:FOURTH",
    "3:false:FIFTH"
  }, delimiter = ':')
  @DisplayName("보너스 숫자가 맞을때 2등, 틀릴때 3등 return")
  public void grade(int matched, boolean isMatchBonus, GradeEnum grade) {
    GradeEnum gradeEnum = GradeEnum.fromGrade(matched, isMatchBonus);

    assertThat(gradeEnum).isEqualTo(grade);
  }

  @Test
  @DisplayName("enum list 순서 상금 역순으로 return / NONE 제외")
  public void sorted() {
    List<GradeEnum> list = GradeEnum.sorted();
    
    assertThat(list.get(0)).isEqualTo(GradeEnum.FIFTH);
    assertThat(list.get(list.size() - 1)).isEqualTo(GradeEnum.FIRST);
  }
}
