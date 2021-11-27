package lotto.view;

import lotto.domain.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Output {
    private static StringBuilder stringBuilder = new StringBuilder();

    private Output() {
    }

    public static void viewPurchasedLotto(Lottos lottos) {
        System.out.println("수동으로 3장, 자동으로 11개를 구매했습니다.");
        for (Lotto lotto : lottos.getLottos()) {
            List<Integer> view = new ArrayList<>();
            lotto.getLottoNumbers().stream()
                    .map(number -> number.getLottoNumber())
                    .forEach(i -> view.add(i));
            System.out.println(view);
        }
    }

    public static void viewResult(Lottos lottos, Integer purchaseAmount, WinningLotto winningLotto, LottoNumber bonus) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        Arrays.stream(Prize.values())
                .forEach(prize -> {
                    stringBuilder.setLength(0);
                    if (prize == Prize.SECOND) {
                        stringBuilder = stringBuilder.append(", 보너스 볼 일치");
                    }
                    System.out.println(prize.getMatching() + "개 일치" + stringBuilder.toString() + "(" + prize.getPrize() + ") - " + lottos.getCount(prize, winningLotto, bonus) + " 개 일치");
                });

        System.out.println("총 수익률은 " + new Double(lottos.getPrize(winningLotto, bonus)) / new Double(purchaseAmount) + "입니다.");
    }
}
