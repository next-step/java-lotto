package lotto;

import java.util.List;

public class OutputView {
    public static void outputCnt(int auto, int manual) {
        System.out.println("수동으로 " + manual + "장, 자동으로 " + auto + "개를 구매했습니다.");
    }

    public static void outputLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getLotto());
        }
    }

    public static void winningNumberPrint(LottoResult result) {
        System.out.println("당첨통계");
        for (Rank rank : Rank.values()) {
            System.out.println(rank.getSameNumberCnt() + "개 일치 : ("
                    + rank.getWinningAmount() + ") : " + result.getValue(rank));
        }
    }

    public static void rateOfReturn(Money prize, Money buyMoney) {
        System.out.println(buyMoney.rateOfReturn(prize));
    }
}
