package lotto.view;

import lotto.model.Rank;

import java.util.EnumMap;

public class ResultView {
    private final String results = "당첨 통계\n---------";
    public EnumMap<Rank, Integer> showWinningResult(EnumMap<Rank, Integer> winningStatics) {
        System.out.println(results);
        for(Rank rank : Rank.values()){
            printExceptNomatch(rank, winningStatics);
        }

        return winningStatics;
    }

    public void printExceptNomatch(Rank rank, EnumMap<Rank, Integer> winningStatics){
        if(rank.getMoney() !=0){
            int count = winningStatics.get(rank) / rank.getMoney();
            System.out.println(rank.getWinningCount()+"개 일치 ("+rank.getMoney()+"원)- "+count+"개");
        }
    }


}
