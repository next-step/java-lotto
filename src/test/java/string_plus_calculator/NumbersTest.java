package string_plus_calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumbersTest {

  @Test
  @DisplayName("Numbers 에 할당된 숫자들을 모두 더한다.")
  void sum() {
    //given
    List<Number> sampleList = Arrays.asList(Number.from("1"), Number.from("2"), Number.from("3"));
    Numbers numbers = new Numbers(sampleList);
    //when
    int sum = numbers.sum();
    //then
    assertEquals(sum, 6);
  }
}
