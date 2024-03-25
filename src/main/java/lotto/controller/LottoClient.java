package lotto.controller;

import lotto.domain.*;

import java.util.List;

import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;

public class LottoClient {

    public static void main(String[] args) {
        printPlainMessage("구입금액을 입력해 주세요.");
        Cash cash = generateCash();
        printCash(cash);
        LottoGroup lottoGroup = generateLottoGroupAndPrint(cash);
        WinningNumber winningNumber = insertWinningNumbers();
        Profit profit = new Profit(0);
        MatchCache matchCache = new MatchCache();
        lottoGroup.saveMatchResult(winningNumber, matchCache, profit);
        printResult(cash, profit, matchCache);
    }

    private static WinningNumber insertWinningNumbers() {
        List<Integer> latestWinningNumbers = insertLatestWinningNumbers();
        int bonusNumber = insertBonusNumber();
        return new WinningNumber(latestWinningNumbers, bonusNumber);
    }

    private static LottoGroup generateLottoGroupAndPrint(Cash cash) {
        LottoGroup lottoGroup = new LottoGroup(new LottoGenerator());
        lottoGroup.generateTickets(cash);
        printLottoGroup(lottoGroup);
        return lottoGroup;
    }

    private static List<Integer> insertLatestWinningNumbers() {
        printPlainMessage("지난 주 당첨 번호를 입력해 주세요.");
        return generateLatestWinningNumbers();
    }

    private static int insertBonusNumber() {
        printPlainMessage("보너스 볼을 입력해 주세요.");
        return insertNumber();
    }

    private static void printResult(Cash cash, Profit profit, MatchCache matchCache) {
        printMatchCache(matchCache);
        printPlainMessage("당첨 통계");
        printPlainMessage("---------");
        printProfit(profit, cash);
    }
}
