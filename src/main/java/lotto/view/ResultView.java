package lotto.view;

import lotto.domain.*;
import lotto.domain.BuyLotto;

import java.util.*;

public class ResultView {

    public void buyLottoAndNumbersPrint(BuyLotto buyLotto) {
        System.out.println(buyLotto.getTotalAmount() + "개를 구매했습니다.");

        for (Lotto lotto : buyLotto.getLotto()) {
            System.out.println(lotto.convertLottoNumbers());
        }
    }

    public void resultPrint(List<Integer> targetNumbers, int bonusNumber, BuyLotto buyLotto) {
        new InputValid(targetNumbers);

        System.out.println("\n당첨 통계");
        System.out.println("--------");

        Map<Rank, List<Rank>> result = buyLotto.getMatchLottoCount(targetNumbers, bonusNumber);
        setMatchPrintCount(result);

        result.entrySet()
                .stream()
                .sorted(Comparator.comparingLong(entry -> entry.getKey().getWinningMoney()))
                .forEach(this::resultMatchPrint);

        profitPrint(buyLotto, result);
    }

    private void setMatchPrintCount(Map<Rank, List<Rank>> result) {
        Arrays.stream(Rank.values()).filter(match -> match != Rank.MISS)
            .forEach(match -> result.computeIfAbsent(match, r -> new ArrayList<>()));
    }

    private void resultMatchPrint(Map.Entry<Rank, List<Rank>> entry) {
        System.out.println(entry.getKey().getCountOfMatch() + "개 일치 " + "(" + entry.getKey().getWinningMoney() + "원)- " + entry.getValue().size() + "개");
    }

    private void profitPrint(BuyLotto buyLotto, Map<Rank, List<Rank>> result) {
        double profit = result.values()
                .stream()
                .flatMap(List::stream)
                .mapToLong(Rank::getWinningMoney)
                .sum();
        double profitRate = profit / buyLotto.getMoney();
        resultJudgePrint(profitRate);
    }

    private void resultJudgePrint(double profitRate) {
        System.out.println("총 수익률은 " + (double) (int)(profitRate*100) / 100.0 + "입니다.(기준이 1이기 때문에 결과적으로 "+ Judge.judge(profitRate).getJudgeMessage() +")");
    }
}
