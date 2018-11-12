package lotto.lottoView;

import lotto.LottoResult;

import java.util.List;

public class ResultView {

    public static void printTotalCount(int count){
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printAllLotteries(List<List<Integer>> lotteries){
        for(List<Integer> lotto : lotteries){
            makeString(lotto);
        }
    }

    public static void makeString(List<Integer> lotto){
        String list = "";
        list += "[";
        for(int a : lotto){
            list+= a+", ";
        }
        list = list.substring(0,list.lastIndexOf(", "));
        list +="]";

        System.out.println(list);
    }

    public static void makeStatistic(int[] arr){
        System.out.println("3개 일치 (5000원) - " +arr[3] + "개");
        System.out.println("4개 일치 (50000원) - " +arr[4] + "개");
        System.out.println("5개 일치 (1500000원) - " +arr[5] + "개");
        System.out.println("6개 일치 (2000000000원) - " +arr[6] + "개");

    }
    public static void winRate(int[] arr,int cost){
        System.out.println("당첨 통계");
        System.out.println("---------");
        makeStatistic(arr);
        LottoResult lr = new LottoResult(arr);
        System.out.println("총 수익률은 "+lr.calculateRate(lr.getTotalSum(),cost)+"입니다.");
    }
}
