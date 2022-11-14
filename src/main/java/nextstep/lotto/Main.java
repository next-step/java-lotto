package nextstep.lotto;

import java.util.Scanner;
import nextstep.lotto.view.InputSupplier;
import nextstep.lotto.view.InputView;
import nextstep.lotto.view.OutputConsumer;
import nextstep.lotto.view.ResultView;

public class Main {

  public static void main(String[] args) {

    final Scanner scanner = new Scanner(System.in);
    final InputSupplier inputSupplier = scanner::nextLine;
    final OutputConsumer outputConsumer = System.out::println;

    final InputView inputView = new InputView(inputSupplier, outputConsumer);
    final ResultView resultView = new ResultView(outputConsumer);

    final LottoSimulationGame lottoSimulationGame = new LottoSimulationGame(inputView, resultView);
    lottoSimulationGame.run();
  }
}
