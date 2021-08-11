package lotto.domain;

import static java.util.stream.IntStream.range;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
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
    List<Integer> values = getSampleLottoNumbers(7);

    Lotto lotto = new Lotto();

    Method creatLotteNumber = lotto.getClass()
        .getDeclaredMethod("creatLotteNumber", List.class);
    creatLotteNumber.setAccessible(true);
    creatLotteNumber.invoke(lotto, values);

    assertThat(lotto.getLotto().size()).isEqualTo(6);
  }

  @DisplayName("로또번호 목록에서 6개를 담아서 정렬되는지 테스트")
  @Test
  void 로또번호정렬() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    List<Integer> values = getSampleLottoNumbers(7);

    Lotto lotto = new Lotto();

    Method creatLotteNumber = lotto.getClass()
        .getDeclaredMethod("creatLotteNumber", List.class);
    creatLotteNumber.setAccessible(true);
    creatLotteNumber.invoke(lotto, values);

    assertThat(lotto.getLotto()
        .stream()
        .map(LottoNumber::getNumber)
        .findFirst()
        .get()).isEqualTo(1);

    assertThat(lotto.getLotto()
        .stream()
        .skip(lotto.getLotto().size() - 1)
        .map(LottoNumber::getNumber)
        .findFirst()
        .get()).isEqualTo(6);
  }

  @DisplayName("중복없는 숫자 6개를 가져와 로또 하나 생성 테스트.")
  @Test
  void 로또한장생성() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    List<Integer> values = getSampleLottoNumbers(7);

    Lotto lotto = new Lotto();

    Method creatLotteNumber = lotto.getClass()
        .getDeclaredMethod("creatLotteNumber", List.class);
    creatLotteNumber.setAccessible(true);
    creatLotteNumber.invoke(lotto, values);

    assertThat(lotto.getLotto().size()).isEqualTo(6);

    Set<Integer> checkValues = lotto.getLotto()
        .stream()
        .map(LottoNumber::getNumber)
        .collect(Collectors.toSet());

    assertThat(checkValues.size()).isEqualTo(6);
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

    List<Integer> values = getSampleLottoNumbers(1);

    assertThatThrownBy(() ->new Lotto(values))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage(Message.MSG_ERROR_INPUT_LOTTO_SIZE);
  }

  @DisplayName("로또안에 숫자와 비교하는 값이 포함되있으면 1을 리턴하는 테스트.")
  @ParameterizedTest
  @ValueSource(ints = {1,2,3,4,5,6})
  void 로또숫자안에비교숫자가있으면값반환(int inputValue) {

    Lotto lotto = new Lotto(getSampleLottoNumbers(7));

    assertThat(lotto.matchCount(new LottoNumber(inputValue))).isEqualTo(1);
  }

  private List<Integer> getSampleLottoNumbers(final int i) {
    List<Integer> values = new ArrayList<>();
    range(1, i).forEach(values::add);
    return values;
  }
}