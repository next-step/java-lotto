package view;

import domain.Lotto;
import domain.LottoGame;

import java.util.List;

public class ResultView {

    public static List<Lotto> winStats(List<Lotto> lottos, Lotto lastLotto){
        System.out.println("당첨통계");
        System.out.println("---------");

        for(Lotto originLotto : lottos) {
            LottoGame.getCombineCount(originLotto, lastLotto);
        }
        return LottoGame.getCombineLottos();
    }
    //맞춘 개수 몇개인지 분류
    public static int[] winCalculate(){
        return LottoGame.winCalculate();
    }

    public static int winResult(){
        return LottoGame.winResult();
    }

    public static double totalEarningRate(int price, int rewards){
        double result =  (double)rewards/(double)price;

        if(price== 0 || rewards == 0){
            result = 0.0;
        }
        String sentence = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
        if(result >= 1){
            sentence = "(개이득)";
        }
       System.out.println(String.format("총 수익률은 %1$,.2f입니다."+sentence,result));
        return result;
    }
}
