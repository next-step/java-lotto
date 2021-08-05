package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.strategy.GenerateLottoNumber;
import lotto.strategy.TestGenerateLottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LotteTest {

  @DisplayName("1~45 로또번호 리스트 생성 테스트.")
  @Test
  void 로또번호리스트생성() {

    GenerateLottoNumber generateLottoNumber = new TestGenerateLottoNumber(1,46);

    List<LottoNumber> numberPull = generateLottoNumber.createNumberPull();

    assertThat(numberPull.size()).isEqualTo(45);

    assertThat(numberPull
        .stream()
        .map(LottoNumber::getNumber)
        .findFirst()
        .get()).isEqualTo(1);

    assertThat(numberPull
        .stream()
        .skip(numberPull.size()-1)
        .map(LottoNumber::getNumber)
        .findFirst()
        .get()).isEqualTo(45);
  }

  @DisplayName("중복없는 숫자 6개를 가져와 로또 하나 생성 테스트.")
  @Test
  void 로또한장생성() {
    Lotto lotte = new Lotto();
    List<Integer> testLotto = createTestLotto(1,2,3,4,5,6);

    GenerateLottoNumber generateLottoNumber = new TestGenerateLottoNumber(0,6,testLotto);
    lotte.creatLotte(generateLottoNumber);

    assertThat(lotte.getLotto().size()).isEqualTo(6);

    Set<Integer> checkValues = lotte.getLotto()
        .stream()
        .map(LottoNumber::getNumber)
        .collect(Collectors.toSet());

    assertThat(checkValues.size()).isEqualTo(6);
  }

  @DisplayName("동일한 로또번호가 들어가면 에러가 발생하는지 테스트.")
  @ParameterizedTest
  @CsvSource(value = {"1:1:1:1:1:1","1:2:3:4:4:5"})
  void 동일로또번호방지(String input) {
    assertThatThrownBy(() -> new Lotto(new ArrayList<>(Arrays.asList(input.split(":")))))
        .isInstanceOf(IllegalArgumentException.class);
  }

  private List<Integer> createTestLotto(int num1, int num2, int num3, int num4, int num5,
      int num6) {
    List<Integer> testLotto = new ArrayList<>();
    testLotto.add(num1);
    testLotto.add(num2);
    testLotto.add(num3);
    testLotto.add(num4);
    testLotto.add(num5);
    testLotto.add(num6);

    return testLotto;
  }
}