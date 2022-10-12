package lotto.client;

import lotto.model.Lotteries;
import lotto.model.enumeration.Rank;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.model.enumeration.Rank.MISS;
import static lotto.model.enumeration.Rank.SECOND;

public class OutputView {

    private static final String LOTTO_FORM = "[{result}]";
    private static final String RANK_FORM = "{matchCount}개 일치{matchBonus}({amount}원)- {count}개";
    private static final String RETURN_RATE_FORM = "총 수익률은 {rate} 입니다.";

    private OutputView() {
        throw new AssertionError();
    }

    public static void showCountOfLotto(Lotteries lotteries) {
        show(String.format("%s개를 구매했습니다.", lotteries.getLottoCount()));
    }

    public static void showCreatedLotteries(Lotteries lotteries) {
        lotteries.getLotteries().forEach(lotto -> {
                    String result = lotto.getLotto().stream()
                            .map(number -> String.valueOf(number.getValue()))
                            .collect(Collectors.joining(", "));

                    show(LOTTO_FORM.replace("{result}", result));
                }
        );

        nextLine();
    }

    public static void showResultRank(Map<Rank, Long> lotteriesRank) {
        show("당첨 통계");
        show("---------");

        Arrays.stream(Rank.values()).filter(rank -> !MISS.equals(rank))
                .sorted(Comparator.comparingDouble(Rank::getCountOfMatch))
                .forEach((value) ->
                        show(RANK_FORM.replace("{matchCount}", String.valueOf((int) value.getCountOfMatch()))
                                .replace("{amount}", String.valueOf(value.getWinningMoney()))
                                .replace("{matchBonus}", SECOND.equals(value) ? ", 보너스 볼 일치" : " ")
                                .replace("{count}", String.valueOf(Optional.ofNullable(lotteriesRank.get(value)).orElse(0L))))
                );
    }

    public static void showReturnRate(Lotteries lotteries, Map<Rank, Long> lotteriesRank, int purchaseAmount) {
        double returnRate = lotteries.getTotalWinningMoney(lotteriesRank) / purchaseAmount;

        show(RETURN_RATE_FORM.replace("{rate}", String.format("%.2f", returnRate)));

        if (returnRate < 1) {
            show("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }

    public static void show(String message) {
        System.out.println(message);
    }

    public static void nextLine() {
        System.out.println();
    }
}
