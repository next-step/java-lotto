package view;

import java.util.Scanner;

public class InputView {

  public static String question() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("계산할 식을 입력하세요");
    return scanner.nextLine();
  }

}
