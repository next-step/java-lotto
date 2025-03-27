package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import lotto.domain.Lotto;
import lotto.domain.LottoChecker;
import lotto.domain.LottoNumberGenerator;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

  private static final int LOTTO_PRICE = 1_000;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int purchaseAmount = InputView.getPurchaseAmount(scanner);
    int ticketCount = purchaseAmount / LOTTO_PRICE;

    List<Lotto> tickets = new ArrayList<>();

    for (int i = 0; i < ticketCount; i++) {
      tickets.add(new Lotto(LottoNumberGenerator.getInstance().generate()));
    }

    ResultView.showLottos(tickets);

    List<Integer> winningNumbers = InputView.getWinningNumbers(scanner);

    Map<Integer, Long> lottoResults = LottoChecker.calculateResults(tickets, winningNumbers);
    double profitRate = LottoChecker.calculateProfitRate(lottoResults, purchaseAmount);
    ResultView.printResults(lottoResults, profitRate);
    scanner.close();
  }


}
