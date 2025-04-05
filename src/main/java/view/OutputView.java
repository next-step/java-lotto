package view;

import lotto.Lotto;
import lotto.LottoNumber;
import lotto.LottoRank;
import lotto.LottosResult;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class OutputView {

    public static void showResult(int result) {
        System.out.println("result = " + result);
    }

    public static void showTotalLottoCount(int manualLottoCount, int autoLottoCount) {
        System.out.println("\n수동으로 " + manualLottoCount + "장, 자동으로 " + autoLottoCount + "개를 구매했습니다.");
    }

    public static void showLottoNumbers(Set<LottoNumber> numbers) {
        System.out.println(numbers);
    }

    public static void showLottoRankResult(LottosResult lottosResult) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
        Arrays.stream(LottoRank.values())
                .filter(match -> match != LottoRank.NONE)
                .forEach(match -> {
                    int count = lottosResult.getLottoRankCount(match);
                    System.out.println(match.toString() + " - " + count + "개 일치");
                });
    }

    public static void showTotalYieldRate(double totalYieldRate) {
        System.out.printf("총 수익률은 %.2f입니다.\n", totalYieldRate);
    }

    public static void showGeneratedLottoNumber(List<Lotto> lottos) {
        lottos.forEach(lotto -> showLottoNumbers(lotto.getLottoNumbers()));
    }
}

