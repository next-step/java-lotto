package lotto;

import java.util.Scanner;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;

public final class LottoManager {

  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      System.out.println("구입금액을 입력해 주세요.");
      int money = Integer.parseInt(scanner.nextLine());

      Money userMoney = new Money(money);
      Lottos userLottos = new Lottos(userMoney);
      System.out.println(userLottos.count() + "개를 구매했습니다.");

      // 번호 나열하는게 있어야겠다.
      System.out.println();

      System.out.println("지난 주 당첨 번호를 입력해주세요.");
      String winningNumberString = scanner.nextLine();
      String[] winningNumbers = winningNumberString.split(", ");
      Lotto winningLotto = new Lotto(winningNumbers);

      System.out.println();
      System.out.println("당첨 통계");
      System.out.println("----------");
      // 통계 출력하는게 있어야겠다.
    }
  }
}
