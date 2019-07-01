package lotto.controller;

import lotto.domain.*;
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
    int manualBuyLottoCount = InputView.manualBuyLotto(scanner);
    LottoTickets tickets = InputView.getLottoTickets(scanner, manualBuyLottoCount);
    ResultView.printBuyCount(buyLottoCount, manualBuyLottoCount);

    LottoTickets lottoTickets = LottoTickets.of(buyLottoCount, tickets);
    ResultView.printTickets(lottoTickets);

    LottoNumbers winNumbers = LottoNumbers.of(InputView.winNumbers(scanner));
    LottoNumber bonusNumber = LottoNumber.of(InputView.bonusNumber(scanner));
    WinNumber winNumber = new WinNumber(winNumbers, bonusNumber);
    List<Rank> ranks = lottoTickets.winNumberSize(winNumber);

    WinLotto statistics = LottoStatistics.statistics(ranks);
    ResultView.printRanks(statistics);

    ResultView.printProfitRate(LottoStatistics.profitRate(inputPrice, statistics));

    scanner.close();
  }
}
