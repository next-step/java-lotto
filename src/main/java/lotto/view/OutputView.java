package lotto.view;

import lotto.domain.BuyLottos;
import lotto.domain.Lotto;
import lotto.domain.RankMatches;

import java.util.Map;

public class OutputView {

    private static final String NEW_LINE = "\n";
    private static final String BOUNDARY = "---------";

    public static void printLottoResult(){
        System.out.println("당첨 통계" + NEW_LINE + BOUNDARY);
    }

    public static void printBuyLotto(BuyLottos buyLottos){
        for(Lotto lotto: buyLottos.getLottos()){
            System.out.println(lotto.getLottoList());
        }
    }

    public static void printNumOfAutoAndManual(int numAuto, int numManual){
        System.out.println("수동으로 "+numAuto+"장, 자동으로 "+numManual+"개를 구매했습니다.");
    }

    public static void printRank(Map<RankMatches, Integer> rankOfLottos){
        for (Map.Entry<RankMatches, Integer> entry : rankOfLottos.entrySet()) {
            RankMatches rank = entry.getKey();
            int count = rank.getCount();
            int prize = rank.getPrize();
            int matches = entry.getValue();

            if(count!=1) {
                System.out.println(count + "개 일치 (" + prize + "원) - " + matches + "개");
            }
            if(count==1){
                System.out.println(count + "개 일치, 보너스 볼 일치 (" + prize + "원) - " + matches + "개");
            }
        }
    }


    public static void printCalProfit(Map<RankMatches, Integer> rankOfLottos, int priceOfLottos){
        float result = 0;

        for(RankMatches rankMatches : rankOfLottos.keySet()){
            result = result + (rankMatches.getPrize() * rankOfLottos.get(rankMatches));
        }
        System.out.printf("총 수익률은 "+ "%.2f" + "입니다." + calProfit(result/priceOfLottos),result/priceOfLottos);
    }

    private static String calProfit(float input){
        if(input > 1){
            return "(기준이 1이기 때문에 결과적으로 이익이라는 의미임)";
        }
        if(input == 1){
            return "(기준이 1이기 때문에 결과적으로 변동없다는 의미임)";
        }
        return "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    }
}
