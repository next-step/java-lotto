package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NumbersTest {

  @Test
  void 생성자_정상_확인_테스트(){
    Numbers numbers = new Numbers("1","2","3");

    assertThat(numbers).isNotNull();
    assertThat(1).isEqualTo(numbers.nextValue());
    assertThat(2).isEqualTo(numbers.nextValue());
    assertThat(3).isEqualTo(numbers.nextValue());
  }

  @Test
  void 숫자가_아닌_문자가_들어오는_경우_생성자_실패_테스트() {
    assertThatThrownBy(() -> new Numbers("1", "2", "a"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("숫자가 아닌 값이 있습니다.");
  }

}