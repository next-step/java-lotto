package com.cheolhyeonpark.lotto.view;

import com.cheolhyeonpark.lotto.domain.GameResult;
import com.cheolhyeonpark.lotto.domain.LottoNumbers;
import com.cheolhyeonpark.lotto.domain.LottoNumbersList;
import com.cheolhyeonpark.lotto.domain.Rank;

import java.util.stream.IntStream;

public class ResultView {

    public void printLottoNumbersList(LottoNumbersList lottoNumbersList) {
        System.out.println(lottoNumbersList.size() + "개를 구매했습니다.");
        IntStream.range(0, lottoNumbersList.size()).mapToObj(lottoNumbersList::getNumbers)
                .map(LottoNumbers::toString).forEach(System.out::println);
    }

    public void printGameResult(GameResult gameResult, int amount) {
        int[] count = {3, 4, 5, 5, 6};
        boolean[] hasBonus = {false, false, false, true, false};
        System.out.println("\n당첨 통계\n------------");
        IntStream.rangeClosed(0, 4).forEach(i -> {
            Rank rank = Rank.findRank(count[i], hasBonus[i]);
            System.out.println(count[i] + "개 일치" + (hasBonus[i] ? ", 보너스 볼 일치" : "")
                   + " (" + rank.getPrice() + "원)- " + gameResult.getCount(rank) + "개");
        });
        System.out.printf("총 수익률은 %.2f 입니다.\n", gameResult.getYields(amount));
    }
}
