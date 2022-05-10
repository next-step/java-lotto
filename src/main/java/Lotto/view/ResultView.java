package Lotto.view;

import Lotto.domain.Lottos;
import Lotto.domain.EqualLottoCntInfo;

import java.util.Map;

public class ResultView {

    private ResultView() {}

    private static int LOTTO_LAST_NUMBER = 6;

    public static void viewLottoNumbers(Lottos lottos) {
        int lottoNum = lottos.getLottoCnt();
        System.out.println(lottoNum + "개를 구매했습니다.");

        for (int i = 0; i < lottoNum; ++i) {
            System.out.print("[");
            viewLottoNumbers(lottos, i);
            System.out.print("]");
            System.out.println();
        }
        System.out.println();
    }

    private static void viewLottoNumbers(Lottos lottos, int i) {
        for (int j = 0; j < LOTTO_LAST_NUMBER; ++j) {
            System.out.print(lottos.getLotto(i).getLottoNumber(j));
            if (j < LOTTO_LAST_NUMBER - 1)
                System.out.print(", ");
        }
    }

    public static void viewResultBoard(Map<EqualLottoCntInfo, Integer> result) {
        System.out.println("당첨 통계");
        System.out.println("--------");

        for (EqualLottoCntInfo equalLottoCntInfo : EqualLottoCntInfo.values()) {
            viewResultMessage(result, equalLottoCntInfo);
        }
    }

    private static void viewResultMessage(Map<EqualLottoCntInfo, Integer> result, EqualLottoCntInfo equalLottoCntInfo) {
        if (equalLottoCntInfo.isWinning()) {
            Integer sameRankCount = result.get(equalLottoCntInfo);
            if (sameRankCount == null) {
                sameRankCount = 0;
            }

            String bonusStr = isWinningBonusNumber(equalLottoCntInfo);

            System.out.println(equalLottoCntInfo.getEqualCnt() + "개 일치 " + bonusStr + "(" + equalLottoCntInfo.getWinningMoney() + "원)" + " - " + sameRankCount + "개");
        }
    }

    private static String isWinningBonusNumber(EqualLottoCntInfo equalLottoCntInfo) {
        String str = "";
        if ((equalLottoCntInfo == EqualLottoCntInfo.BONUS) && (equalLottoCntInfo.getEqualCnt() == 5))
            str = ", 보너스 볼 일치";
        return str;
    }

    public static void viewLottoYield(double yield) {
        System.out.println("총 수익율은 " + yield + "입니다.");
    }
}
