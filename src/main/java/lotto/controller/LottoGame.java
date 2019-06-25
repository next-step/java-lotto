package lotto.controller;

import lotto.util.LottoStatistics;
import lotto.domain.LottoStore;
import lotto.domain.LottoTickets;
import lotto.domain.Rank;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Map;
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
    List<Rank> ranks = lottoTickets.winNumberSize(winNumbers);

    Map<Rank, Long> statistics = LottoStatistics.statistics(ranks);
    ResultView.printRanks(statistics);

    ResultView.printProfitRate(LottoStatistics.profitRate(inputPrice, statistics));

    scanner.close();
  }
}
