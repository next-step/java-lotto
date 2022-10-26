package view;

import java.util.Map;

import domain.Lotto;
import domain.LottoResult;
import domain.Lottos;
import domain.Money;
import enums.LottoWinnerRank;

import static enums.LottoWinnerRank.*;

public class ResultView {

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

    private static int sumSecondAndThirdCount(Map<LottoWinnerRank, Integer> matchFounds) {
        int result = 0;
        if (matchFounds.get(SECOND) != null) {
            result += matchFounds.get(SECOND);
        }
        if (matchFounds.get(THIRD) != null) {
            result += matchFounds.get(THIRD);
        }
        return result;
    }

    public static void winnerStatistic(LottoResult lottoResult, Money purchasedMoney) {

        Map<LottoWinnerRank, Integer> matchFounds = lottoResult.getMatchFoundCount();
        double earningRate = lottoResult.calculateEarningRate(purchasedMoney);
        String lossMessage = lossMessageFormat(earningRate);

        System.out.println("당첨 통계");
        System.out.println("-----------");
        System.out.println("3개 일치 (5000원)- " + matchFounds.getOrDefault(FIFTH, 0) + "개");
        System.out.println("4개 일치 (50000원)- " + matchFounds.getOrDefault(FOURTH, 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치(30000000원)- " + sumSecondAndThirdCount(matchFounds) + "개");
        System.out.println("6개 일치 (2000000000원)- " + matchFounds.getOrDefault(FIRST, 0) + "개");
        System.out.println("총 수익률은 " + earningRate + "입니다." + lossMessage);
    }

}
