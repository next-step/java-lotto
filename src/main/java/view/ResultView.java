package view;

import java.util.Map;

import domain.Lotto;
import domain.LottoResult;
import domain.Lottos;
import domain.Money;

public class ResultView {

    private static final int THREE_MATCH = 3;
    private static final int FOUR_MATCH = 4;
    private static final int FIVE_MATCH = 5;
    private static final int SIX_MATCH = 6;

    public static void printRandomLotto(Lottos randomLotto) {
        int purchaseCount = randomLotto.getLottoNumbers().size();

        System.out.println(purchaseCount + "개를 구매했습니다.");
        for (Lotto lottoNumber : randomLotto.getLottoNumbers()) {
            System.out.println(lottoNumber.getLotto());
        }
    }

    public static String lossMessageFormat(double rate) {
        return rate < 1 ? "(기준이 1이기 때문에 결과적으로 손해라는 의미임)" : "";
    }

    public static void winnerStatistic(LottoResult lottoResult, Money purchasedMoney) {

        Map<Integer, Integer> matchFounds = lottoResult.getMatchFoundCount();
        double earningRate = lottoResult.calculateEarningRate(purchasedMoney);

        String lossMessage = lossMessageFormat(earningRate);

        System.out.println("당첨 통계");
        System.out.println("-----------");
        System.out.println("3개 일치 (5000원)- " + matchFounds.getOrDefault(THREE_MATCH, 0) + "개");
        System.out.println("4개 일치 (50000원)- " + matchFounds.getOrDefault(FOUR_MATCH, 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치(1500000원)- " + matchFounds.getOrDefault(FIVE_MATCH, 0) + "개");
        System.out.println("6개 일치 (2000000000원)- " + matchFounds.getOrDefault(SIX_MATCH, 0) + "개");
        System.out.println("총 수익률은 " + earningRate + "입니다." + lossMessage);
    }
}
