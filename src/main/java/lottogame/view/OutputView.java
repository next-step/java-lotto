package lottogame.view;

import lottogame.model.Lottos;
import lottogame.model.Rank;
import lottogame.model.WinningStatistics;

import java.util.Arrays;
import java.util.stream.Collectors;

public class OutputView {

    public void resultBuyPrice(int buyCount, int manualBuyCount) {
        System.out.println("수동으로 " + manualBuyCount + "장, 자동으로 " + buyCount + "개를 구매했습니다.");
    }

    public void resultLottoList(Lottos lottos) {
        lottos.getLottos().stream().forEach(
                lotto -> System.out.println(lotto.getNumbers().stream()
                        .map(lottoNumber -> String.valueOf(lottoNumber.getNumber()))
                        .collect(Collectors.joining(",", "[", "]"))
                ));
    }

    public void resultStatistics(WinningStatistics winning) {

        Arrays.stream(Rank.values()).filter(rank -> rank != Rank.MISS).forEach(rank -> {
            if (winning.getStatistics().get(rank) != null) {
                System.out.println(rank.getMessage() + "(" + rank.getMoney() + "원) - " + winning.getStatistics().get(rank) + "개");
            } else {
                System.out.println(rank.getMessage() + "(" + rank.getMoney() + "원) - " + 0 + "개");
            }
        });

        System.out.println("총 수익률 은 " + winning.yield() + "입니다");

    }
}
