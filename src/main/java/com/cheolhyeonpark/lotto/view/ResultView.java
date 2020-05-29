package com.cheolhyeonpark.lotto.view;

import com.cheolhyeonpark.lotto.domain.GameResult;
import com.cheolhyeonpark.lotto.domain.LottoNumbersList;
import com.cheolhyeonpark.lotto.domain.Rank;

import java.util.stream.IntStream;

public class ResultView {

    public void printLottoNumbersList(LottoNumbersList lottoNumbersList) {
        System.out.println(lottoNumbersList.size() + "개를 구매했습니다.");
        IntStream.range(0, lottoNumbersList.size()).mapToObj(lottoNumbersList::getNumbers).forEach(System.out::println);
    }

    public void printGameResult(GameResult gameResult, int amount) {
        System.out.println("\n당첨 통계\n------------");
        IntStream.rangeClosed(3, 6).forEach(i -> {
            Rank rank = Rank.findRank(i);
            System.out.println(i + "개 일 (" + rank.getPrice() + "원)- " + gameResult.getCount(rank) + "개");
        });
        System.out.printf("총 수익률은 %.2f 입니다.\n", gameResult.getYields(amount));
    }
}
