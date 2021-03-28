package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberTest {

  @ParameterizedTest
  @ValueSource(ints = {1, 45})
  @DisplayName("Number가 생성이 잘되는가")
  public void create(int value) throws Exception {
    //given
    //when
    Number number = new Number(value);
    //then
    assertEquals(value, number.getNumber());
  }

  @ParameterizedTest
  @ValueSource(ints = {0, 46})
  @DisplayName("Number의 입력 값이 Lotto 범위 미만 혹은 초과 시 익셉션이 발생하는")
  public void isThrowRangeException(int bound) throws Exception {
    //given
    //when
    //then
    assertThrows(IllegalArgumentException.class,
        () -> new Number(bound));
  }
}