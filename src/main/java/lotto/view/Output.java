package lotto.view;

import lotto.domain.*;
import lotto.domain.Number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Output {
    private static StringBuilder stringBuilder = new StringBuilder();

    private Output() {
    }

    public static void viewPurchasedLotto(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            List<Integer> view = new ArrayList<>();
            lotto.getLottoNumbers().stream().map(number -> number.getNumber()).forEach(i -> view.add(i));
            System.out.println(view);
        }
    }

    public static void viewResult(Lottos lottos, Integer purchaseAmount, WinningNumbers winningNumbers, Number bonus) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        Integer startIndex = 3;
        for (int index = startIndex; index < Prize.values().length; index++) {
            stringBuilder.setLength(0);
            Prize prize = Arrays.asList(Prize.values()).get(index);
            if (prize == Prize.BONUS_SECOND) {
                stringBuilder = stringBuilder.append(", 보너스 볼 일치");
            }
            System.out.println(prize.getMatching() + "개 일치" + stringBuilder.toString() + "(" + prize.getPrize() + ") - " + lottos.getCount(prize, winningNumbers, bonus) + " 개 일치");
        }
        System.out.println("총 수익률은 " + new Double(lottos.getPrize(winningNumbers, bonus)) / new Double(purchaseAmount) + "입니다.");
    }
}
