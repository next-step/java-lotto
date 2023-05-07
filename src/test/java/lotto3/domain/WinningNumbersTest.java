package lotto3.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {


  @Test
  void 당첨번호가_1번보다_작다면_예외_던지는_테스트() {
    List<Integer> numbers = List.of(0, 1, 2, 3, 4, 5);
    assertThat(catchThrowable(() -> new WinningNumbers(numbers)))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("로또 번호는 1부터 45까지의 숫자만 가능합니다.");
  }

  @Test
  void 당첨번호가_45번보다_큰다면_예외_던지는_테스트() {
    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 46);
    assertThat(catchThrowable(() -> new WinningNumbers(numbers)))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("로또 번호는 1부터 45까지의 숫자만 가능합니다.");
  }

  @Test
  void 당첨번호_개수가_6개를_넘어가면_예외_던지는_검증() {
    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);
    assertThat(catchThrowable(() -> new WinningNumbers(numbers)))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("지난 주 당첨 번호는 6개를 입력해 주세요.");
  }

  @Test
  void 보너스번호가_당첨번호와_중복될_경우_예외를_던진다() {
    WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
    LottoNumber duplicateBonusNumber = new LottoNumber(6);

    assertThatThrownBy(() -> winningNumbers.validateHasDuplicateNumber(duplicateBonusNumber))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("보너스 볼은 당첨 번호와 중복될 수 없습니다.");
  }

  @Test
  void 당첨번호는_중복번호가_있으면_안된다() {
    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 5);
    assertThat(catchThrowable(() -> new WinningNumbers(numbers)))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("당첨 번호는 중복될 수 없습니다.");

  }
}