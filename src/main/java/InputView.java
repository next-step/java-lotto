import java.util.Scanner;

public class InputView {

  private final Scanner scanner;

  public InputView() {
    scanner = new Scanner(System.in);
  }

  public String readFormula() {
    System.out.println("식을 입력하세요.");
    return scanner.nextLine();
  }
}
