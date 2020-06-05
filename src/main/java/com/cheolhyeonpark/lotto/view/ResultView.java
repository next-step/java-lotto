package com.cheolhyeonpark.lotto.view;

import com.cheolhyeonpark.lotto.domain.Amount;
import com.cheolhyeonpark.lotto.domain.LottoResult;
import com.cheolhyeonpark.lotto.domain.number.LottoTicket;
import com.cheolhyeonpark.lotto.domain.number.Numbers;
import com.cheolhyeonpark.lotto.domain.Rank;

import java.util.stream.IntStream;

public class ResultView {

    public void printLottoNumbersList(LottoTicket lottoTicket) {
        System.out.println("\n" + lottoTicket.size() + "개를 구매했습니다.");
        IntStream.range(0, lottoTicket.size()).mapToObj(lottoTicket::getNumbers)
                .map(Numbers::toString).forEach(System.out::println);
    }

    public void printGameResult(LottoResult result, Amount amount) {
        int[] count = {3, 4, 5, 5, 6};
        boolean[] hasBonus = {false, false, false, true, false};
        System.out.println("\n당첨 통계\n------------");
        IntStream.rangeClosed(0, 4).forEach(i -> {
            Rank rank = Rank.findRank(count[i], hasBonus[i]);
            System.out.println(count[i] + "개 일치" + (hasBonus[i] ? ", 보너스 볼 일치" : "")
                   + " (" + rank.getPrice() + "원)- " + result.getCount(rank) + "개");
        });
        System.out.printf("총 수익률은 %.2f 입니다.\n", result.getYields(amount));
    }
}
