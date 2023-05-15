package lotto.view;

import lotto.domain.Lottos;
import lotto.domain.Rank;
import lotto.domain.WinNumbers;

public class Output {
    private final Lottos lottos;

    public Output(Lottos lottos) {
        this.lottos = lottos;
    }

    public void printNumbers() {
        System.out.println("수동으로 " + this.lottos.getManualLottoCount() + "장, 자동으로 " + this.lottos.getAutoLottoCount() + "개를 구매했습니다.");
        lottos.getNumbers().forEach(System.out::println);
        System.out.println();
    }

    public void printStatistics(WinNumbers winNumbers) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원)- " + this.lottos.getRankCount(winNumbers).get(Rank.FIFTH) + "개");
        System.out.println("4개 일치 (50000원)- " + this.lottos.getRankCount(winNumbers).get(Rank.FOURTH) + "개");
        System.out.println("5개 일치 (150000원)- " + this.lottos.getRankCount(winNumbers).get(Rank.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치(30000000원)- " + this.lottos.getRankCount(winNumbers).get(Rank.SECOND) + "개");
        System.out.println("6개 일치 (2000000000원)- " + this.lottos.getRankCount(winNumbers).get(Rank.FIRST) + "개");
        System.out.println("총 수익률은 " + this.lottos.getEarningRate(winNumbers) + "입니다.(기준이 1이기 때문에 결과적으로 " + getResult(winNumbers) + "(이)라는 의미임)");
        System.out.println();
    }

    private String getResult(WinNumbers winNumbers) {
        if (this.lottos.isGain(winNumbers)) {
            return "이익";
        }
        if (this.lottos.isLoss(winNumbers)) {
            return "손해";
        }
        return "동률";
    }
}
