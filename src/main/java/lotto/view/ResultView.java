package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class ResultView {
    public static void printLottoCount(int lottoCount){
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            StringBuilder sb = new StringBuilder("[");
            for (Integer lottoNumber : lotto.getLottoNumbers()) {
                sb.append(lottoNumber).append(", ");
            }
            sb.delete(sb.length()-2,sb.length()).append("]");
            System.out.println(sb);
        }
        System.out.println();
    }

    public static void printResultSubject(){
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    public static void printPrizeResult(int[] prizeArray){
        for (int i=prizeArray.length-1; i>0; i--) {
            printPrize(i, prizeArray[i]);
        }
    }

    private static void printPrize(int i, int count) {
        if (i == 4) {
            printFourthResult(count);
        }
        if (i == 3) {
            printThirdResult(count);
        }
        if (i == 2) {
            printSecondResult(count);
        }
        if (i == 1) {
            printFirstResult(count);
        }
    }

    private static void printFourthResult(int count){
        System.out.printf("3개 일치 (5000원)- %d개" ,count);
        System.out.println();
    }

    private static void printThirdResult(int count){
        System.out.printf("4개 일치 (50000원)- %d개" ,count);
        System.out.println();
    }

    private static void printSecondResult(int count){
        System.out.printf("5개 일치 (1500000원)- %d개" ,count);
        System.out.println();
    }

    private static void printFirstResult(int count){
        System.out.printf("6개 일치 (2000000000원)- %d개" ,count);
        System.out.println();
    }

    public static void printProfitRate(double profitRate){
        System.out.printf("총 수익률은 %.2f입니다.",profitRate);
    }
}
