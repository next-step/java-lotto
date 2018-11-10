package view;

public class ResultView {

    public static  void viewStats() {
        System.out.println("당첨통계");
        System.out.println("---------");

    }

    public static void printResult(double result){
        System.out.println(String.format("총 수익률은 %1$,.2f입니다. (기준이 1이기 때문에 결과적으로 손해라는 의미임)",result));
    }

    public static void printBuyLottoCount(int lottoCount) {
        System.out.println(String.format("%s개를 구매했습니다.", lottoCount));
    }

}
