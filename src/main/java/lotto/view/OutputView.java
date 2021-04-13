package lotto.view;

import lotto.enums.Rank;

import java.util.HashMap;

public class OutputView {
    private int lottoCount = 0;

    public OutputView(int lottoCount) {
        this.lottoCount = lottoCount;
    }

    public void printLottoCnt() {
        System.out.println(this.lottoCount + "개를 구매했습니다.");
    }


    public void printLottoResult(HashMap<Rank, Integer> rankMap) {
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
