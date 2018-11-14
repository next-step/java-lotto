package lotto.lottoView;

import lotto.Lotto;
import lotto.LottoResult;
import lotto.Rank;

import java.util.List;


public class ResultView {

    public static void printTotalCount(int count){
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printAllLotteries(List<Lotto> lotteries){
        for(Lotto lotto : lotteries){
            makeString(lotto);
        }
    }

    public static void makeString(Lotto lotto){
        String numberList = "";
        numberList += "[";
        for(int a : lotto.getNumber()){
            numberList += a+", ";
        }
        numberList = numberList.substring(0, numberList.lastIndexOf(", "));
        numberList += "]";

        System.out.println(numberList);
    }

    public static void makeStatistic(LottoResult result){
        System.out.println("3개 일치 (5000원) - " +result.get(Rank.FIFTH) + "개");
        System.out.println("4개 일치 (50000원) - " +result.get(Rank.FOURTH) + "개");
        System.out.println("5개 일치 (1500000원) - " +result.get(Rank.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치(30000000원) - " +result.get(Rank.SECOND) + "개");
        System.out.println("6개 일치 (2000000000원) - " +result.get(Rank.FIRST) + "개");

    }
    public static void winRate(LottoResult result, int cost){
        System.out.println("당첨 통계");
        System.out.println("---------");
        makeStatistic(result);
        System.out.println("총 수익률은 "+result.calculateRate(result.getTotalSum(),cost)+"입니다.");
    }
}
