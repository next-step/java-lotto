package calculator.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class InputViewTest {
  @DisplayName("자동차 대수를 입력받는 기능 테스트")
  @Test
  void testGetCarCountInput() {
    String testInput = "1 + 2 * 3";
    Scanner testScanner = new Scanner(testInput + "\n");
    InputView inputView = new InputView(testScanner);

    String actual = inputView.receiveUserInput();

    Assertions.assertEquals(testInput, actual);
  }
}