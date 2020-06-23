package lotto.view;

import lotto.domain.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {
    private static StringBuilder stringBuilder;

    public static void printLotto(List<Lotto> lottos, int manualLottoCount) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("수동으로 ").append(manualLottoCount).append("장, ");
        stringBuilder.append("자동으로 ").append(lottos.size() - manualLottoCount).append("개를 구매했습니다.\n");

        lottos.forEach(lotto -> {
            printLottoNumbers(lotto.getLottoNumbers());
            stringBuilder.append("\n");
        });
        System.out.print(stringBuilder.toString());
    }

    private static void printLottoNumbers(List<LottoNumber> lottoNumbers) {
        List<Integer> numbers = lottoNumbers.stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList());
        stringBuilder.append(numbers);
    }

    public static void printResult(Map<Rank, Integer> lottoResult, Money money) {
        stringBuilder = new StringBuilder();

        stringBuilder.append("당첨 통계\n");
        stringBuilder.append("---------\n");
        double profit = 0.0;
        for (Rank rank : Rank.values()) {
            printMatch(lottoResult, rank);
            profit += rank.getWinningMoney() * lottoResult.getOrDefault(rank, 0);
        }

        stringBuilder.append("총 수익률은 ");
        stringBuilder.append(money.statistics(profit));
        stringBuilder.append("입니다.");
        System.out.println(stringBuilder.toString());
    }

    private static void printMatch(Map<Rank, Integer> lottoResult, Rank rank) {
        if (rank.equals(Rank.MISS)) {
            return;
        }
        stringBuilder.append(rank.getCountOfMatch());
        stringBuilder.append("개 ");
        if (rank.equals(Rank.SECOND)) {
            stringBuilder.append("일치, 보너스 볼 ");
        }
        stringBuilder.append("일치 (");
        stringBuilder.append(rank.getWinningMoney());
        stringBuilder.append("원)- ");
        stringBuilder.append(lottoResult.get(rank));
        stringBuilder.append("개\n");
    }
}
