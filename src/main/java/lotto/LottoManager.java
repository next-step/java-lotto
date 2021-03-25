package lotto;

import java.util.Scanner;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.io.InputView;
import lotto.io.Printer;

public final class LottoManager {

  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      InputView inputView = new InputView(scanner);
      int money = inputView.inputMoney();

      Money userMoney = new Money(money);
      Lottos userLottos = new Lottos(userMoney);
      Printer.printLottoCount(userLottos);
      Printer.printLottos(userLottos);

      Lotto winningLotto = inputView.inputLastWinningNumber();
      Printer.printWinningStatistics(userLottos, winningLotto);
    }
  }
}
