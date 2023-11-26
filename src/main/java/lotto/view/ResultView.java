package lotto.view;

import lotto.domain.MatchResult;
import lotto.domain.Rank;
import lotto.domain.MyLottos;

import java.util.Arrays;

public class ResultView {

    public static void printLottoCount(int lottoCount){
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printMyLottos(MyLottos myLottos, int lottoCount){
        for(int i = 0; i < lottoCount; i++){
            System.out.println(Arrays.toString(myLottos.lottoNumbersToArray(i)));
        }
    }

    public static void printMatchResult(MatchResult matchResult){
        for (Rank rank : Rank.values()){
            if(rank.getMatchCount() == 0) continue;
            System.out.println(rank.getMatchCount() + "개 일치 (" + rank.getWinningMoney() + ") - " + matchResult.matchCountOf(rank) + "개");
        }
    }

    public static void printReturnRate(double returnRate){
        System.out.println("총 수익률은 " + returnRate + "입니다.");
    }
}
