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
  @DisplayName("List<Number>를 통해서 Lotto 클래스를 생성할 수 있는가")
  public void isCreateByNumbers() throws Exception {
    //given
    //when
    Lotto lotto = Lotto.generatedManualLottoNumber(Arrays.asList(1,2,3,4,5,6));

    //then
    assertEquals(lotto.getNumbers(), lotto.getNumbers());
  }


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
}