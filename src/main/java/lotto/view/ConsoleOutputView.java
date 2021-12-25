package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.stat.LottoRank;
import lotto.domain.stat.LottoRankCountMap;
import lotto.domain.stat.LottoResult;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ConsoleOutputView {

    public void printLottos(Lottos lottos) {
        Collection<Lotto> lottoCollection = lottos.collect();

        System.out.println(lottoCollection.size() + "개를 구매했습니다.");
        lottoCollection.forEach(this::printLotto);
        System.out.println();
    }

    private void printLotto(Lotto lotto) {
        Set<LottoNumber> lotttoNumbers = lotto.getLottoNumbers();

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        String numbersString = lotttoNumbers.stream()
                .map(LottoNumber::getNumber)
                .sorted()
                .map((num) -> num+"")
                .collect(Collectors.joining(", "));

        sb.append(numbersString);
        sb.append("]");

        System.out.println(sb.toString());
    }

    public void showResult(LottoResult result) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        LottoRankCountMap lottoRankCountMap = result.getRankCountMap();

        for (LottoRank lottoRank : LottoRank.values()) {
            int count = lottoRankCountMap.get(lottoRank);
            printRankAndCount(lottoRank, count);
        }

        printTotalReward(result.getTotalReward());
        printProfitRate(result.getProfitRate());

        System.out.println();
    }

    private void printTotalReward(Money totalReqward) {
        System.out.println("총 상금: " + totalReqward);
    }

    private void printProfitRate(double profitRate) {
        System.out.print("총 수익률은: " + String.format("%.2f", profitRate) + "입니다.");
        if (profitRate < 1) {
            System.out.print("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }

    private void printRankAndCount(LottoRank lottoRank, int count) {
        if (lottoRank.isNotNone()) {
            System.out.println(lottoRank.getNumberOfMatches() + "개 일치 (" + lottoRank.getReward() + "원)- " + count + "개");
        }
    }

}
