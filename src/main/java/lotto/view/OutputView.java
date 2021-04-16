package lotto.view;

import lotto.enums.Rank;

import java.util.Map;

public class OutputView {
    private int totalLottoCount = 0;
    private int autoLottoCount = 0;
    private int manualLottoCount = 0;

    public OutputView(int totalLottoCount, int autoLottoCount, int manualLottoCount) {
        this(totalLottoCount);
        this.autoLottoCount = autoLottoCount;
        this.manualLottoCount = manualLottoCount;
    }

    public OutputView(int totalLottoCount) {
        this.totalLottoCount = totalLottoCount;
    }


    public void printLottoCnt() {
        System.out.println("총 " + this.totalLottoCount + "장 구입, 수동으로 " + this.manualLottoCount + "장, 쟈동으로 " + this.autoLottoCount + "개를 구매했습니다.");
    }


    public void printLottoResult(Map<Rank, Integer> rankMap) {
        System.out.println("당첨 통계");
        System.out.println("----------");
        System.out.println("3개 일치(5,000원)- " + rankMap.get(Rank.FIFTH) + "개");
        System.out.println("4개 일치(50,000원)- " + rankMap.get(Rank.FOURTH) + "개");
        System.out.println("5개 일치(1,500,000원)- " + rankMap.get(Rank.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치(30,000,000원)- " + rankMap.get(Rank.SECOND) + "개");
        System.out.println("6개 일치(2,000,000,000원)- " + rankMap.get(Rank.FIRST) + "개");
    }

    public void printRate(float winRate) {
        System.out.println("총 수익률은 " + winRate);
    }

}
