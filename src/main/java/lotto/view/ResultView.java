package lotto.view;

import lotto.util.LottoUtil;
import lotto.domain.MyLottos;
import lotto.domain.WinningMoney;

import java.util.Arrays;
import java.util.List;

public class ResultView {
    private static final int MIN_MATCH_COUNT = 3;
    private static final int MAX_MATCH_COUNT = 6;
    private static final WinningMoney winningMoney = new WinningMoney();

    public static void main(String[] args) {
        int payMoney = InputView.inputPayMoney();
        int lottoCount = LottoUtil.returnLottoCount(payMoney);
        printLottoCount(lottoCount);

        MyLottos myLottos = new MyLottos(lottoCount);
        printMyLottos(myLottos, lottoCount);

        List<Integer> winningNumbers = InputView.inputWinningNumbers();
        myLottos.matchingNumbers(winningNumbers);

        printMatchResult(myLottos);

        printReturnRate(myLottos.returnRate(payMoney));
    }

    public static void printLottoCount(int lottoCount){
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printMyLottos(MyLottos myLottos, int lottoCount){
        for(int i = 0; i < lottoCount; i++){
            System.out.println(Arrays.toString(myLottos.lottoNumbersToArray(i)));
        }
    }

    public static void printMatchResult(MyLottos myLottos){
        for (int matchCount = MIN_MATCH_COUNT; matchCount <= MAX_MATCH_COUNT; matchCount++) {
            System.out.println(matchCount + "개 일치 (" + winningMoney.winningMoneyOf(matchCount) + ") - " + myLottos.returnMatchCountOf(matchCount) + "개");
        }
    }

    public static void printReturnRate(double returnRate){
        System.out.println("총 수익률은 " + returnRate + "입니다.");
    }
}
