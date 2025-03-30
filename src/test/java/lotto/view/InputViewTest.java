package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

  private static Scanner getTestScanner(String input) {
    return new Scanner(input);
  }

  @DisplayName("숫자가 아닌 금액을 입력받을 시 에러")
  @Test
  void testReceiveMoneyWithInvalidInput() {
    String testInput = "notANumber";
    InputView inputView = new InputView(getTestScanner(testInput));

    assertThatThrownBy(inputView::receiveMoney)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("숫자가 아닌 값이 포함되어 있습니다.");
  }

  @DisplayName("보너스 볼을 입력받는 기능 테스트")
  @Test
  void testReceiveBonusNumber() {
    String testInput = "1";
    InputView inputView = new InputView(getTestScanner(testInput));

    LottoNumber actual = inputView.receiveBonusNumber();

    assertEquals(new LottoNumber(1), actual);
  }

  @DisplayName("숫자가 아닌 보너스 볼을 입력받을 시 에러")
  @Test
  void testReceiveNotNumberBonusBall() {
    String testInput = "a";
    InputView inputView = new InputView(getTestScanner(testInput));

    assertThatThrownBy(inputView::receiveMoney)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("숫자가 아닌 값이 포함되어 있습니다.");
  }

  @DisplayName("로또 번호를 입력받는 기능 테스트")
  @Test
  void testReceiveWinningLottoNumbers() {
    String testInput = "1, 2, 3, 4, 5, 6";
    InputView inputView = new InputView(getTestScanner(testInput));

    assertThat(inputView.receiveWinningLottoNumbers())
            .containsExactly(
                    new LottoNumber(1),
                    new LottoNumber(2),
                    new LottoNumber(3),
                    new LottoNumber(4),
                    new LottoNumber(5),
                    new LottoNumber(6)
            );
  }

  @DisplayName("직접 로또 번호를 입력받는 기능 테스트")
  @Test
  void testReceiveManualLottos() {
    String testInput = "1, 2, 3, 4, 5, 6\n7, 8, 9, 10, 11, 12\n\n";
    InputView inputView = new InputView(getTestScanner(testInput));

    assertThat(inputView.receiveManualLottos()).allMatch(lotto ->
            List.of(
                    "[1, 2, 3, 4, 5, 6]", "[7, 8, 9, 10, 11, 12]"
            ).contains(lotto.getNumberRepresentation()));
  }
}