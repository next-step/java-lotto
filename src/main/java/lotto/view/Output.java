package lotto.view;

import lotto.domain.Lottos;
import lotto.domain.WinNumbers;

public class Output {
    private final Lottos lottos;

    public Output(Lottos lottos) {
        this.lottos = lottos;
    }

    public void printNumbers() {
        System.out.println(this.lottos.getLottoCount() + "개를 구매했습니다.");
        lottos.getNumbers().forEach(System.out::println);
        System.out.println();
    }

    public void printStatistics(WinNumbers winNumbers) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원)- " + this.lottos.getFourthRankCount(winNumbers) + "개");
        System.out.println("4개 일치 (50000원)- " + this.lottos.getThirdRankCount(winNumbers) + "개");
        System.out.println("5개 일치 (150000원)- " + this.lottos.getSecondRankCount(winNumbers) + "개");
        System.out.println("6개 일치 (2000000000원)- " + this.lottos.getFirstRankCount(winNumbers) + "개");
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
