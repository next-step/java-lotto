package study.step2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.step2.validator.Validator;

public class ValidatorTest {

  @DisplayName("1000원을 입력했을 때, validator 통과하는지 테스트")
  @Test
  void validatorMoneySuccess() {
    // given
    int money = 1000;

    // when
    Throwable thrown = catchThrowable(() -> {
      Validator.validatorMoney(money);
    });

    // then
    assertThat(thrown).isEqualTo(null);
  }

  @DisplayName("900원을 입력했을 때, 에러가 발생하는지 테스트")
  @Test
  void validatorMoneyFail() {
    // given
    int money = 900;

    // when
    Throwable thrown = catchThrowable(() -> {
      Validator.validatorMoney(money);
    });

    // then
    assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("입력한 로또 번호가 비어있을 경우 Exception 테스트")
  @Test
  void validatorIsEmpty() {
    // given
    String text = "";

    // when
    Throwable thrown = catchThrowable(() -> {
      Validator.isEmpty(text);
    });

    // then
    assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("입력한 로또 번호에 음수가 포함되어있을 경우 Exception 테스트")
  @Test
  void validatorPositiveNumbersNumbers() {
    // given
    Set<Integer> positiveNumbers = new HashSet<>(Arrays.asList(1, -1, 3, 4, 6, 11));

    // when
    Throwable thrown = catchThrowable(() -> {
      Validator.validatorPositiveNumbers(positiveNumbers);
    });

    // then
    assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("입력한 로또 번호에 중복된 번호가 포함되어있을 경우 Exception 테스트")
  @Test
  void checkDuplication() {
    // given
    Set<Integer> numbers = new HashSet<>(Arrays.asList(1, 1, 3, 4, 6, 11));

    // when
    Throwable thrown = catchThrowable(() -> {
      Validator.checkDuplication(numbers);
    });

    // then
    assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
  }

}
