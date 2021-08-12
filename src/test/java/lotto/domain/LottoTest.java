package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.message.Message;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTest {

  @DisplayName("6개의 번호로 로또 생성 테스트.")
  @Test
  void 로또번호생성() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

    Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    Lotto targetLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

    Method creatLotteNumber = lotto.getClass()
        .getDeclaredMethod("creatLotteNumber", List.class);
    creatLotteNumber.setAccessible(true);

    assertThat(creatLotteNumber.invoke(lotto, Arrays.asList(1, 2, 3, 4, 5, 6))).isEqualTo(
        creatLotteNumber.invoke(targetLotto, Arrays.asList(1, 2, 3, 4, 5, 6)));
  }

  @DisplayName("동일한 로또번호가 들어가면 에러가 발생하는지 테스트.")
  @ParameterizedTest
  @CsvSource(value = {"1:1:1:1:1:1", "1:2:3:4:4:5"})
  void 동일로또번호방지(String input) {

    assertThatThrownBy(() -> new Lotto(
        Arrays.stream(input.split(":"))
            .map(Integer::parseInt)
            .collect(Collectors.toList()))
    ).isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("로또 입력 갯수 6개 미달 여부 판별 테스트.")
  @Test
  void 로또번호입력개수검증() {

    List<Integer> values = Arrays.asList(1,2);

    assertThatThrownBy(() -> new Lotto(values))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage(Message.MSG_ERROR_INPUT_LOTTO_SIZE);
  }

  @DisplayName("로또안에 숫자와 비교하는 값이 포함되있으면 1을 리턴하는 테스트.")
  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3, 4, 5, 6})
  void 로또숫자안에비교숫자가있으면값반환(int inputValue) {

    Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

    assertThat(lotto.matchCount(new LottoNumber(inputValue))).isEqualTo(1);
  }

  @DisplayName("로또객체 두개를 서로 비교하여 일치하는 개수를 반환하는 테스트.")
  @ParameterizedTest
  @CsvSource(value = {"1:12:13:14:15:16,1", "1:2:13:14:15:16,2", "1:2:3:14:15:16,3", "1:2:3:4:15:16,4", "1:2:3:4:5:16,5", "1:2:3:4:5:6,6"})
  void 로또간에일치하는번호카운트(String input, int count) {

    Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

    Lotto winLotto = new Lotto(Arrays.stream(input.split(":"))
        .map(Integer::parseInt)
        .collect(Collectors.toList()));

    assertThat(lotto.matchLotto(winLotto)).isEqualTo(count);
  }
}