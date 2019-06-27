package lotto.controller;

import lotto.domain.LottoStore;
import lotto.domain.LottoTickets;
import lotto.domain.Rank;
import lotto.domain.WinLotto;
import lotto.util.LottoStatistics;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Scanner;

public class LottoGame {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int inputPrice = InputView.inputPrice(scanner);
    int buyLottoCount = LottoStore.buyLottoCount(inputPrice);
    ResultView.printBuyCount(buyLottoCount);

    LottoTickets lottoTickets = new LottoTickets(buyLottoCount);
    ResultView.printTickets(lottoTickets.getTickets());

    List<Integer> winNumbers = InputView.winNumbers(scanner);
    int bonusNumber = InputView.bonusNumber(scanner);
    List<Rank> ranks = lottoTickets.winNumberSize(winNumbers, bonusNumber);

    WinLotto statistics = LottoStatistics.statistics(ranks);
    ResultView.printRanks(statistics);

    ResultView.printProfitRate(LottoStatistics.profitRate(inputPrice, statistics));

    scanner.close();
  }
}
