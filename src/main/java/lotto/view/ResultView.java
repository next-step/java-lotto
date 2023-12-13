package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.MatchResult;
import lotto.domain.Rank;
import lotto.domain.MyLottos;

import java.util.Arrays;

public class ResultView {

    public static void printLottoCount(int lottoCount){
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printMyLottos(MyLottos myLottos){
        for(Lotto lotto : myLottos.myLottos()) {
            System.out.println(lotto.toString());
        }
    }

    public static void printMatchResult(MatchResult matchResult){
        System.out.println("당첨 통계");
        System.out.println("--------------");
        for (Rank rank : Rank.values()){
            printRank(rank, matchResult);
        }
    }

    public static void printRank(Rank rank, MatchResult matchResult) {
        if(rank == Rank.SECOND){
            System.out.println(rank.getMatchCount() + "개 일치, 보너스볼 일치(" + rank.getWinningMoney() + ") - " + matchResult.matchCountOf(rank) + "개");
        }
        if(rank != Rank.MISS && rank != Rank.SECOND){
            System.out.println(rank.getMatchCount() + "개 일치 (" + rank.getWinningMoney() + ") - " + matchResult.matchCountOf(rank) + "개");
        }
    }

    public static void printReturnRate(double returnRate){
        System.out.print("총 수익률은 " + returnRate + "입니다.");
        if(returnRate < 1){
            System.out.print("기준이 1이기 때문에 결과적으로 손해라는 의미임");
        }
    }
}
