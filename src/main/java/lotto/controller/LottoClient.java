package lotto.controller;

import lotto.domain.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.view.InputView.insertNumber;
import static lotto.view.InputView.insertValues;
import static lotto.view.OutputView.printPlainMessage;

public class LottoClient {

    public static void main(String[] args) {
        printPlainMessage("구입금액을 입력해 주세요.");
        Cash cash = new Cash(insertNumber());
        printPlainMessage(cash.toString());
        LottoGroup lottoGroup = generateLottoGroupAndPrint(cash);
        List<Integer> latestWinningNumbers = insertLatestWinningNumbers();
        Profit profit = new Profit(0);
        MatchCache matchCache = new MatchCache();
        cacheMatchResultAndCalculateProfit(lottoGroup, latestWinningNumbers, profit, matchCache);
        printResult(cash, profit, matchCache);
    }

    private static LottoGroup generateLottoGroupAndPrint(Cash cash) {
        LottoGroup lottoGroup = new LottoGroup(new LottoGenerator());
        lottoGroup.generateTickets(cash);
        printPlainMessage(lottoGroup.toString());
        return lottoGroup;
    }

    private static List<Integer> insertLatestWinningNumbers() {
        printPlainMessage("지난 주 당첨 번호를 입력해 주세요.");
        return getLatestWinningNumbers();
    }

    private static void printResult(Cash cash, Profit profit, MatchCache matchCache) {
        printPlainMessage(matchCache.toString());
        printPlainMessage("당첨 통계");
        printPlainMessage("---------");
        printPlainMessage(profit.toString(cash));
    }

    private static void cacheMatchResultAndCalculateProfit(LottoGroup lottoGroup, List<Integer> latestWinningNumbers, Profit profit, MatchCache matchCache) {
        lottoGroup.getTickets().forEach(iter -> {
            int count = Match.getCount(latestWinningNumbers, iter);
            matchCache.save(count);
            profit.accumulate(count);
        });
    }

    private static List<Integer> getLatestWinningNumbers() {
        String str = insertValues();
        return Arrays.stream(str.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
