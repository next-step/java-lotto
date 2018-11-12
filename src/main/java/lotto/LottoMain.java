package lotto;

import lotto.lottoView.InputView;
import lotto.lottoView.ResultView;

import java.util.ArrayList;
import java.util.List;

import static lotto.lottoView.InputView.inputWinNumbers;
import static lotto.lottoView.ResultView.printAllLotteries;
import static lotto.lottoView.ResultView.winRate;

public class LottoMain {

    public static void main(String[] args){
         int[] arr = new int[]{0,0,0,0,0,0,0};
         List<List<Integer>> list = new ArrayList();

        LottoInit cost = new LottoInit(InputView.inputInitCost());
        ResultView.printTotalCount(cost.getCount()); // 갯수 입력& 결과출력

        Lotteries lts = new Lotteries(cost.getCount());
        list = lts.buyLotto();

        printAllLotteries(list); // 구매한 로또 모두 출력!

        LottoCompare lc = new LottoCompare(inputWinNumbers());

        for(List<Integer> arrList : list) {
            arr[lc.CompareNumber(arrList)]++;
        }

        winRate(arr,cost.getCost());





    }


}
