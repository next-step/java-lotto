package lotto.view;

import lotto.Lotto;

import java.util.Map;

public class ResultView {
    private int ticketCount;

    public ResultView(int ticketCount){
        this.ticketCount = ticketCount;
    }

    public void showWinningResult(Map<Integer,Integer> winningStatic){
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원)- "+winningStatic.get(3)+"개");
        System.out.println("4개 일치 (50000원)- "+winningStatic.get(4)+"개");
        System.out.println("5개 일치 (1500000원)- "+winningStatic.get(5)+"개");
        System.out.println("6개 일치 (2000000000원)- "+winningStatic.get(6)+"개");
        resultBenefit(winningStatic);
    }

    public void resultBenefit(Map<Integer,Integer> winningStatic){

        double price = winningStatic.get(3) * 5000 + winningStatic.get(4) * 50000
                + winningStatic.get(5) * 1500000 + winningStatic.get(6) * 2000000000;
        System.out.println("수익금 : "+ price);
        System.out.println("총 수익률은 "+(price/(ticketCount*1000))+"입니다.");
    }


}
