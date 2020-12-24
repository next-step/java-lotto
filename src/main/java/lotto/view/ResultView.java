package lotto.view;

import lotto.domain.Judge;
import lotto.domain.LottoNumbers;
import lotto.domain.Match;
import lotto.util.Request;

import java.util.*;

public class ResultView {

    public void buyLottoAndNumbersPrint(Request request) {
        System.out.println(request.getTotalAmount() + "개를 구매했습니다.");

        for (LottoNumbers lotto : request.getLotto()) {
            System.out.println(lotto.convertLottoNumbers());
        }
    }

    public void resultPrint(List<Integer> targetNumbers, Request request) {
        System.out.println("당첨 통계");
        System.out.println("--------");

        Map<Match, List<Match>> result = request.getMatchLottoCount(targetNumbers);
        setMatchPrintCount(result);

        result.entrySet()
                .stream()
                .sorted(Comparator.comparingLong(entry -> entry.getKey().getMatchCount()))
                .forEach(this::resultMatchPrint);

        profitPrint(request, result);
    }

    private void setMatchPrintCount(Map<Match, List<Match>> result) {
        Arrays.stream(Match.values()).filter(match -> match != Match.MISS)
            .forEach(match -> result.computeIfAbsent(match, r -> new ArrayList<>()));
    }

    private void resultMatchPrint(Map.Entry<Match, List<Match>> entry) {
        System.out.println(entry.getKey().getMatchCount() + "개 일치 " + "(" + entry.getKey().getReward() + "원)- " + entry.getValue().size() + "개");
    }

    private void profitPrint(Request request, Map<Match, List<Match>> match) {
        double profit = match.values()
                .stream()
                .flatMap(List::stream)
                .mapToLong(Match::getReward)
                .sum();
        double profitRate = profit / request.getMoney();
        resultJudgePrint(profitRate);
    }

    private void resultJudgePrint(double profitRate) {
        System.out.println("총 수익률은 " + (double) (int)(profitRate*100) / 100 + "입니다.(기준이 1이기 때문에 결과적으로 "+ Judge.judge(profitRate).getJudgeMessage() +")");
    }
}
