package lotto.view;

import lotto.BuyLottos;
import lotto.Lotto;
import lotto.LottoGame;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OutputView {

    private static final String NEW_LINE = "\n";
    private static final String BOUNDARY = "---------";
    private static final int FIRSTPLACE = 0;
    private static final int SECONDPLACE = 1;
    private static final int THIRDPLACE = 2;
    private static final int FOURTHPLACE = 3;

    private static List<Integer> benefit = new ArrayList<>(Arrays.asList(2000000000, 1500000, 50000, 5000));

    public static void printLottoResult(){
        System.out.println("당첨 통계" + NEW_LINE + BOUNDARY);
    }

    public static void printBuyLotto(BuyLottos buyLottos){
        for(Lotto lotto: buyLottos.getLottos()){
            System.out.println(lotto.getLotto());
        }

    }

    public static void printRank(List<Integer> rankOfLottos){
        rankFourth(rankOfLottos.get(FOURTHPLACE));
        rankThird(rankOfLottos.get(THIRDPLACE));
        rankSecond(rankOfLottos.get(SECONDPLACE));
        rankFirst(rankOfLottos.get(FIRSTPLACE));

    }

    private static void rankFourth(int number){
        System.out.println("3개 일치 (5000원) - " + number + "개");
    }
    private static void rankThird(int number){
        System.out.println("4개 일치 (50000원) - " + number + "개");
    }
    private static void rankSecond(int number){
        System.out.println("5개 일치 (1500000원) - " + number + "개");
    }
    private static void rankFirst(int number){
        System.out.println("6개 일치 (2000000000원) - " + number + "개");
    }

    public static void printCalProfit(List<Integer> rankOfLottos, int priceOfLottos){
        float result = 0;
        for(int i=0;i< benefit.size();i++){
            result = result + rankOfLottos.get(i) * benefit.get(i);
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
