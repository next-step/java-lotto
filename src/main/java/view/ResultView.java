package view;

import domain.LottoGame;


public class ResultView {

    public static  void  winStats(LottoGame lottoGame) {
        System.out.println("당첨통계");
        System.out.println("---------");

        lottoGame.getCombineLottos();
        lottoGame.winCalculate();
    }

    public static double totalEarningRate(int price, int rewards){
        double result =  (double)rewards/(double)price;
        if(price== 0 || rewards == 0){
            result = 0.0;
        }
        printResult(result);
        return result;
    }

    public static void printResult(double result){
        System.out.println(String.format("총 수익률은 %1$,.2f입니다. (기준이 1이기 때문에 결과적으로 손해라는 의미임)",result));
    }

}
