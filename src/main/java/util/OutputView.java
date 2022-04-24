package util;

public class OutputView {

  private OutputView() {}


  public static void print(String text, int textRepeatCount) {
    System.out.println(text.repeat(textRepeatCount));
  }
}
