package lotto.view;

import lotto.domain.LottoPurchases;
import lotto.domain.LottoRank;

import java.util.Map;

public class LottoMessage {

    public static void getLottoMessage(String lottoNumber) {
        System.out.println(lottoNumber);
    }

    public static void getLottoRankMessage(Map<LottoRank, Integer> lottoList) {
        System.out.println("당첨 통계\n" + "---------");
        for (LottoRank lottoRank : LottoRank.values()) {
            System.out.println(lottoRank.getMatchingCount() + "개 일치" + (lottoRank.getBonus() ? ", 보너스 볼 일치" : "")
                    + " (" + lottoRank.getReward() + "원)- " + (lottoList.containsKey(lottoRank)
                    ? lottoList.get(lottoRank) : "0") + "개");
        }
    }

    public static void getLottoResultMessage(String returns) {
        System.out.println("총 수익률은 " + returns + "입니다.");
    }

    public static void getLottoDivisionMessage(LottoPurchases lottoPurchases) {
        System.out.println("수동으로 " + lottoPurchases.getPassivityCount() + "장, 자동으로 " + lottoPurchases.getAutomaticCount() + "개를 구매했습니다.");
    }
}
