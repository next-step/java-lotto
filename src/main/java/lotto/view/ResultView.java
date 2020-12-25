package lotto.view;

import lotto.domain.InputValid;
import lotto.domain.Judge;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.util.Request;

import java.util.*;

public class ResultView {

    public void buyLottoAndNumbersPrint(Request request) {
        System.out.println(request.getTotalAmount() + "개를 구매했습니다.");

        for (Lotto lotto : request.getLotto()) {
            System.out.println(lotto.convertLottoNumbers());
        }
    }

    public void resultPrint(List<Integer> targetNumbers, Request request) {
        new InputValid(targetNumbers);

        System.out.println("당첨 통계");
        System.out.println("--------");

        Map<Rank, List<Rank>> result = request.getMatchLottoCount(targetNumbers);
        setMatchPrintCount(result);

        result.entrySet()
                .stream()
                .sorted(Comparator.comparingLong(entry -> entry.getKey().getCountOfMatch()))
                .forEach(this::resultMatchPrint);

        profitPrint(request, result);
    }

    private void setMatchPrintCount(Map<Rank, List<Rank>> result) {
        Arrays.stream(Rank.values()).filter(match -> match != Rank.MISS)
            .forEach(match -> result.computeIfAbsent(match, r -> new ArrayList<>()));
    }

    private void resultMatchPrint(Map.Entry<Rank, List<Rank>> entry) {
        System.out.println(entry.getKey().getCountOfMatch() + "개 일치 " + "(" + entry.getKey().getWinningMoney() + "원)- " + entry.getValue().size() + "개");
    }

    private void profitPrint(Request request, Map<Rank, List<Rank>> match) {
        double profit = match.values()
                .stream()
                .flatMap(List::stream)
                .mapToLong(Rank::getWinningMoney)
                .sum();
        double profitRate = profit / request.getMoney();
        resultJudgePrint(profitRate);
    }

    private void resultJudgePrint(double profitRate) {
        System.out.println("총 수익률은 " + (double) (int)(profitRate*100) / 100 + "입니다.(기준이 1이기 때문에 결과적으로 "+ Judge.judge(profitRate).getJudgeMessage() +")");
    }
}
