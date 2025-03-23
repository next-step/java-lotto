package calculator.utils;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResultViewTest {

  @Test
  void testPrintResult() {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    System.setOut(new PrintStream(outputStream));

    ResultView.printResult(10);

    System.setOut(originalOut);
    String expectedOutput = "결과는 10입니다.\n";
    assertEquals(expectedOutput, outputStream.toString());
  }
}