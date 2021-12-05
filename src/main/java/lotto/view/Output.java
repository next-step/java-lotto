package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.LottosRecord;
import lotto.domain.Prize;

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
            lotto.getLottoNumbers().stream()
                    .map(number -> number.getLottoNumber())
                    .forEach(i -> view.add(i));
            System.out.println(view);
        }
    }

    public static void viewResult(LottosRecord lottosRecord) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        Arrays.stream(Prize.values())
                .forEach(prize -> {
                    stringBuilder.setLength(0);
                    if (prize == Prize.SECOND) {
                        stringBuilder = stringBuilder.append(", 보너스 볼 일치");
                    }
                    System.out.println(prize.getMatching() + "개 일치" + stringBuilder.toString() + "(" + prize.getPrize() + ") - " + lottosRecord.getRecord().get(prize) + " 개 일치");
                });

        System.out.println("총 수익률은 " + lottosRecord.getProfit() + "입니다.");
    }
}
