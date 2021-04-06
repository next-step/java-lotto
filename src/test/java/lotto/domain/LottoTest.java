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

  @Test
  @DisplayName("Lotto를 통해서 당첨 비교를 수행할 수 있는가")
  public void matchTest() throws Exception {
    //given
    Lotto manualLotto = Lotto.createManualLotto(Arrays.asList(6, 5, 4, 3, 2, 1));

    //when
    int matchCount = manualLotto.matchCount(Lotto.createManualLotto(Arrays.asList(6, 7, 8, 9, 10, 11)));

    //then
    assertEquals(matchCount, 1);
  }

  @Test
  @DisplayName("Lotto의 숫자가 몇개가 맞았는지 알아낼 수 있는가")
  public void matchCount() throws Exception {
    //given
    Lotto manualLotto = Lotto.createManualLotto(Arrays.asList(6, 5, 4, 3, 2, 1));
    Lotto targetLotto = Lotto.createManualLotto(Arrays.asList(6, 5, 4, 3, 2, 1));

    //when
    //then
    assertEquals(manualLotto.matchCount(targetLotto), 6);
  }

  @Test
  @DisplayName("size를 알아낼 수 있는가")
  public void size() throws Exception {
    //given
    Lotto autoLotto = Lotto.createAutoLotto();
    //when
    //then
    assertEquals(autoLotto.size(), 6);
  }
}