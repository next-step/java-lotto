package lotto.view;

import lotto.domain.Lottos;
import lotto.domain.Number;
import lotto.domain.Prize;

import java.util.Arrays;
import java.util.List;

public class Output {
    private static StringBuilder stringBuilder = new StringBuilder();

    private Output() {
    }

    public static void viewPurchasedLotto(Lottos lottos) {
        lottos.getLottos().stream().map(randomNumbers -> randomNumbers.getLottoNumbers()).forEach(System.out::println);
    }

    public static void viewResult(Lottos lottos, Integer purchaseAmount, List<Number> winningNumbers, Integer bonus) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        Integer startIndex = 3;
        for (int index = startIndex; index < Prize.values().length; index++) {
            stringBuilder.setLength(0);
            stringBuilder.append("");
            Prize prize = Arrays.asList(Prize.values()).get(index);
            if (prize == Prize.BONUS_SECOND) {
                stringBuilder = stringBuilder.append(", 보너스 볼 일치");
            }
            System.out.println(prize.getMatching() + "개 일치" + stringBuilder.toString() + "(" + prize.getPrize() + ") - " + lottos.getCount(prize, winningNumbers, bonus) + " 개 일치");
        }
        System.out.println("총 수익률은 " + new Double(lottos.getPrize(winningNumbers, bonus)) / new Double(purchaseAmount) + "입니다.");
    }
}
