package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;
import lotto.util.TestRandomGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberTest {

  @Test
  @DisplayName("Number가 생성이 잘되는가")
  public void create() throws Exception {
    //given
    Random random = new Random(System.currentTimeMillis());
    //when
    Number number = new Number(random.nextInt(45) + 1);
    //then
    assertTrue(number.getNumber() > 0 && number.getNumber() < 46);
  }

  @Test
  @DisplayName("Number의 입력 값이 Lotto 범위 미만 혹은 초과 시 익셉션이 발생하는")
  public void isThrowRangeException() throws Exception {
    //given
    TestRandomGenerator testRandomGenerator = new TestRandomGenerator();

    //when
    //then
    assertThrows(IllegalArgumentException.class,
        () -> new Number(testRandomGenerator.generatedRandomNumber()));
  }
}