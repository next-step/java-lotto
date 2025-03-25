package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

  private static Scanner getTestScanner(String input) {
    return new Scanner(input);
  }

  @DisplayName("구입금액을 입력받는 기능 테스트")
  @Test
  void testReceiveMoney() {
    String testInput = "1000";
    InputView inputView = new InputView(getTestScanner(testInput));

    int actual = inputView.receiveMoney();

    assertEquals(1000, actual);
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

  @DisplayName("지난 주 당첨번호를 입력받는 기능 테스트")
  @Test
  void testReceiveWinningLotto() {
    String testInput = "1, 2, 3, 4, 5, 6";
    InputView inputView = new InputView(getTestScanner(testInput));

    String actual = inputView.receiveWinningLotto();

    assertEquals("1, 2, 3, 4, 5, 6", actual);
  }

}