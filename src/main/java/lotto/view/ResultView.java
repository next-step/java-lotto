package lotto.view;

import lotto.domain.*;

import java.util.*;

public class ResultView {
    private final Lottos lottos = new Lottos();

    public void buyLottoAndNumbersPrint(int money) {
        List<Lotto> lottoTickets = lottos.makeLotto(money);
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");

        for (Lotto lotto : lottoTickets) {
            System.out.println(lotto.getLotto());
        }
    }

    public void resultPrint(List<Integer> inputNumbers, int bonusNumber, int money) {
        System.out.println("\n당첨 통계");
        System.out.println("--------");

        WinningLotto winningLotto = new WinningLotto(inputNumbers, bonusNumber);
        Map<Rank, List<Rank>> result = lottos.groupByMatchRanks(winningLotto);
        setMatchPrintCount(result);

        result.entrySet()
                .stream()
                .sorted(Comparator.comparingLong(entry -> entry.getKey().getWinningMoney()))
                .forEach(this::resultMatchPrint);

        resultJudgePrint(result, money);
    }

    private void setMatchPrintCount(Map<Rank, List<Rank>> result) {
        Arrays.stream(Rank.values()).filter(match -> match != Rank.MISS)
            .forEach(match -> result.computeIfAbsent(match, r -> new ArrayList<>()));
    }

    private void resultMatchPrint(Map.Entry<Rank, List<Rank>> entry) {
        System.out.println(entry.getKey().getCountOfMatch() + "개 일치 " + "(" + entry.getKey().getWinningMoney() + "원)- " + entry.getValue().size() + "개");
    }

    public void resultJudgePrint(Map<Rank, List<Rank>> result, int money) {
        double profitRate = lottos.calculateProfit(result, money);
        System.out.println("총 수익률은 " + profitRate + "입니다.(기준이 1이기 때문에 결과적으로 "+ Judge.judge(profitRate).getJudgeMessage() +"라는 의미)");
    }
}
