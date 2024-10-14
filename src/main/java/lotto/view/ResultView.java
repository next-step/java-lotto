package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.Stack;
import java.util.stream.Collectors;

public class ResultView {

    public void NumberOfLotto(int numberOfLotto){
        System.out.println(numberOfLotto+"개를 구매했습니다");
    }

    public void printPurchasedLottos(Lottos lottos){
        for(Lotto lotto : lottos.getLottos()){
            System.out.println(
            lotto.getLotto()
                    .stream()
                    .map(i -> String.valueOf(i))
                    .collect(Collectors.joining(", ","[","]"))
            );
        }

    }

    public void printResult(Stack<Integer> money) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원)- "+money.pop());
        System.out.println("4개 일치 (50000원)- "+money.pop());
        System.out.println("5개 일치 (1500000원)- "+money.pop());
        System.out.println("6개 일치 (2000000000원)- "+money.pop());
    }

    public void printProfit(double profitRate) {
        if(profitRate<1){
            System.out.println("총 수익률은 " + profitRate +"입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
            return ;
        }
        System.out.println("총 수익률은 " + profitRate +"입니다.(기준이 1이기 때문에 결과적으로 이득라는 의미임)");
    }



}
