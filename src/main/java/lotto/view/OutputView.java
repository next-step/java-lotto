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

    public static void printRank(Map<RankMatches, Integer> rankOfLottos){
        for (int i=0;i<rankOfLottos.size();i++) {
            printRankSub(i, rankOfLottos);
        }
    }

    private static void printRankSub(int input, Map<RankMatches, Integer> rankOfLottos){
        if(input!=1) {
            System.out.println(RankMatches.values()[input].getCount() + "개 일치 ("
                    + RankMatches.values()[input].getPrize() + "원)- "
                    + rankOfLottos.get(RankMatches.values()[input]) + "개");
        }
        if(input==1){
            System.out.println(RankMatches.values()[input].getCount() + "개 일치, 보너스 볼 일치 ("
                    + RankMatches.values()[input].getPrize()+"원)- "
                    + rankOfLottos.get(RankMatches.values()[input]) + "개");
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
