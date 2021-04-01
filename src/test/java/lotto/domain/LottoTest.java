package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.exception.LottoNumberDuplicationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

  @Test
  @DisplayName("중복 값이 존재할 경우 익셉션이 발생하는가")
  public void isExistDuplicatedUpdateLotto() throws Exception {
    //given
    List<Number> numbers = new ArrayList<>();

    for(int i = 0; i < 6; i++) {
      numbers.add(new Number(6));
    }

    //when
    LottoNumberDuplicationException thrown =
        assertThrows(LottoNumberDuplicationException.class,
            () -> new Lotto(numbers));

    assertTrue(thrown.getMessage().contains("중복"));
  }

  @Test
  @DisplayName("오름차순으로 정렬이 제대로 되는가")
  public void sort() throws Exception {
    //given
    Lotto descLotto = Lotto.createManualLotto(Arrays.asList(6,5,4,3,2,1));
    Lotto ascLotto = Lotto.createManualLotto(Arrays.asList(1,2,3,4,5,6));

    //when
    //then
    assertEquals(descLotto, ascLotto);
  }
}