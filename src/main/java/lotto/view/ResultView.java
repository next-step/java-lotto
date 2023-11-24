package lotto.view;

import lotto.domain.MatchResult;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.util.LottoUtil;
import lotto.domain.MyLottos;

import java.util.Arrays;

public class ResultView {
    private static final int MIN_MATCH_COUNT = 3;
    private static final int MAX_MATCH_COUNT = 6;

    public static void main(String[] args) {
        int payMoney = InputView.inputPayMoney();
        int lottoCount = LottoUtil.returnLottoCount(payMoney);
        printLottoCount(lottoCount);

        MyLottos myLottos = new MyLottos(lottoCount);
        printMyLottos(myLottos, lottoCount);

        WinningLotto winningLotto = InputView.inputWinningNumbers();
        MatchResult matchResult = myLottos.matchMyLotto(winningLotto);

        printMatchResult(matchResult);

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

    public static void printMatchResult(MatchResult matchResult){
        for (int matchCount = MIN_MATCH_COUNT; matchCount <= MAX_MATCH_COUNT; matchCount++) {
            System.out.println(matchCount + "개 일치 (" + Rank.winningMoneyOf(matchCount) + ") - " + matchResult.matchCountOf(matchCount) + "개");
        }
    }

    public static void printReturnRate(double returnRate){
        System.out.println("총 수익률은 " + returnRate + "입니다.");
    }
}
