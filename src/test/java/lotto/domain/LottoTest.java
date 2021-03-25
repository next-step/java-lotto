package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.util.RandomNumberGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

  private static RandomNumberGenerator generator;

  @BeforeAll
  public static void initRandomNumberGenerator() {
    generator = new RandomNumberGenerator();
  }

  @Test
  @DisplayName("List<Number>를 통해서 Lotto 클래스를 생성할 수 있는가")
  public void isCreateByNumbers() throws Exception {
    //given
    List<Number> numbers = new ArrayList<>();

    numbers.add(new Number(1));
    numbers.add(new Number(2));
    numbers.add(new Number(3));
    numbers.add(new Number(4));
    numbers.add(new Number(5));
    numbers.add(new Number(6));

    //when
    Lotto lotto = new Lotto(numbers);

    //then
    assertEquals(lotto.getNumbers(), numbers);
  }
  
  @Test
  @DisplayName("범위 미만 혹은 초과 시 익셉션이 발생하는가")
  public void isThrowRangeException() throws Exception {
    //given
    List<Number> numbers1 = new ArrayList<>();
    List<Number> numbers2 = new ArrayList<>();

    for(int i = 0; i < 5; i++) {
      numbers1.add(new Number(generator.generatedRandomNumber()));
      if(i % 2 == 0) {
        numbers2.add(new Number(generator.generatedRandomNumber()));
      }
    }
    //when
    //then
    assertAll(
        () -> assertThrows(IllegalArgumentException.class, () -> new Lotto(numbers1)),
        () -> assertThrows(IllegalArgumentException.class, () -> new Lotto(numbers2))
    );
  }

  @Test
  @DisplayName("중복 값이 존재할 경우 새로 난수를 구해서 업데이트 하는가")
  public void isExistDuplicatedUpdateLotto() throws Exception {
    //given
    List<Number> numbers = new ArrayList<>();

    for(int i = 0; i < 6; i++) {
      numbers.add(new Number(6));
    }

    //when
    Lotto lotto = new Lotto(numbers);
    Set<Number> numberSet = new HashSet<>(lotto.getNumbers());

    assertEquals(lotto.getNumbers().size(), numberSet.size());
  }
}