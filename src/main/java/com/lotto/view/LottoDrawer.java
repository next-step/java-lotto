package com.lotto.view;

import com.lotto.model.LottoResult;
import com.lotto.model.Lottos;
import com.lotto.type.RewardType;

import java.util.stream.Collectors;

public class LottoDrawer {
    private static final String LINE_BREAK = "\n";

    public static void drawMoneyInputMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void drawBuyResult(Lottos lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");

        String lottosText = lottos.lottoStream()
                .map(lotto -> String.valueOf(lotto))
                .collect(Collectors.joining(LINE_BREAK));
        System.out.println(lottosText);

        System.out.println();
    }

    public static void drawWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public static void drawBonusNumber() {
        System.out.println("보너스 번호를 입력해주세요.");
    }

    public static void drawResult(LottoResult result, float benefit) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        String resultRows = RewardType.streamExceptMiss()
                .map((rewardType -> makeRewardRow(rewardType, result.getCorrectCount(rewardType))))
                .collect(Collectors.joining(LINE_BREAK));

        System.out.println(resultRows);

        System.out.println(String.format("총 수익률은 %.2f 입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)", benefit));
    }

    private static String makeRewardRow(RewardType reward, int correctCount) {
        int price = reward.getPrice();
        int numberOfCorrect = reward.getNumberOfCorrect();

        if (reward.isBonusNumber()) {
            return String.format("%d개 일치, 보너스 번호 일치 (%,d원) - %d 개", numberOfCorrect, price, correctCount);
        }

        return String.format("%d개 일치 (%,d원) - %d 개", numberOfCorrect, price, correctCount);
    }

    public static void drawWhenUnderMiminumMoney() {
        System.out.println("최소 금액을 입력해주세요.");
    }
}
