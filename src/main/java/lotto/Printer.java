package lotto;

public class Printer {

  private Printer() {};

  public static void print(String message) {
    System.out.println(message);
  }

  public static void printChange(Money change) {
    print(String.format("거스름 돈 %s원이 반환 됩니다.", change));
  }
}
