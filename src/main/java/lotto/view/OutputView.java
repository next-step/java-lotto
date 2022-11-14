package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.Rank;

import java.util.Comparator;
import java.util.List;

public class OutputView {

    public static void PrintLottos(Lottos lottos){

        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(makeLottoString(lotto));
        }
    }

    private static String makeLottoString(Lotto lotto) {

        String printResult = "[";
        List<Integer> lottoList = lotto.getLottoIntegerList();
        lottoList.sort(Comparator.naturalOrder());

        for (int i = 0; i< lottoList.size(); i++) {
            printResult += (lottoList.get(i) +", ");
        }
        printResult = printResult.substring(0,printResult.length()-1) + "]";
        return printResult;
    }

    public static void printResult(LottoResult lottoResult){
        System.out.println("당첨 통계");
        System.out.println("--------");

        for(int i=3; i<=6; i++){
            System.out.println(i+"개 일치 ("+ Rank.of(i).getWinningMoney() +"원) ="+lottoResult.getLottoResult().get(i)+"개");
        }
    }
}
