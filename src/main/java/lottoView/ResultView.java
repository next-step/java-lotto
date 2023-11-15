package lottoView;

import lotto.Lotto;
import lotto.LottoResult;

import java.util.List;

public class ResultView {

    public static void resultCount(int count){
        System.out.println(count+"개를 구매했습니다.");
    }

    public static void printLottoNumber(List<Lotto> lottos){
        for(Lotto lotto: lottos){
            System.out.println(lotto.toString());
        }
    }


    public static void printLottoResult(LottoResult lottoResult){
        System.out.println(lottoResult.toString());
    }
}
