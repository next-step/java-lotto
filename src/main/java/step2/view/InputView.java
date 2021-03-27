package step2.view;

import step2.domain.Cash;
import step2.domain.Lotto;
import step2.domain.Lottos;

import java.util.Scanner;

public class InputView {
  private static final String INPUT_MESSAGE = "구입금액을 입력해 주세요.";
  private static final Scanner scanner = new Scanner(System.in);

  public static int starting(){
    CommonView.println(INPUT_MESSAGE);
    return scanner.nextInt();
  }

  public static void firstNotice(){

  }

}
