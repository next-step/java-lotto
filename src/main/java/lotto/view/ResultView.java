package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.PurchaseMachine;
import lotto.domain.Rank;
import lotto.domain.Statistics;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author han
 */
public class ResultView {


    public void printPurchaseLottos(PurchaseMachine purchaseMachine) {
        List<Lotto> lottoList = purchaseMachine.getLottoList();

        for (Lotto l : lottoList) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            String collect = l.getNumbers().stream().map(String::valueOf).collect(Collectors.joining(","));
            sb.append(collect);
            sb.append("]");
            System.out.println(sb);
        }
    }

    public void printResultStatics(PurchaseMachine purchaseMachine) {
        Statistics statistics = purchaseMachine.getStatistics();
        List<Lotto> lottos = statistics.getLottos();
        List<Rank> ranks = Arrays.asList(Rank.FORTH, Rank.THIRD, Rank.SECOND, Rank.FIRST);
        Map<Rank, Integer> map = new HashMap<>();
        for (Rank r : ranks) {
            map.put(r, 0);
        }

        for (Lotto l : lottos) {
            map.computeIfPresent(l.getRank(), (k, v) -> v + 1);
        }

        Set<Rank> ranks1 = map.keySet();
        ranks1.stream().sorted(Comparator.comparing(Rank::getMatch));

        StringBuilder sb = new StringBuilder();
        int profit = 0;
        for (Rank r : ranks1) {
            sb.append(r.getMatch());
            sb.append("개 일치 ");
            sb.append("(");
            sb.append(r.getMoney());
            sb.append(")- ");
            sb.append(map.get(r));
            if (map.get(r) != 0) {
                profit += r.getMoney();
            }
            sb.append("개");
            sb.append("\n");
        }

        int purchaseAmount = purchaseMachine.getCredit().getPurchaseAmount();
        sb.append("총 수익률은 ");
        sb.append(profit != 0 ? profit / purchaseAmount : 0);
        sb.append("입니다");
        System.out.println(sb);
    }
}
