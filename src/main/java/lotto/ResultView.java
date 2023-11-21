package lotto;

import java.util.Arrays;
import java.util.List;

public class ResultView {
    public static void main(String[] args) {
        int payMoney = InputView.inputPayMoney();
        int lottoCount = LottoUtil.returnLottoCount(payMoney);
        System.out.println(lottoCount + "개를 구매했습니다.");

        MyLottos myLottos = new MyLottos(lottoCount);

        for(int i = 0; i < lottoCount; i++){
            System.out.println(Arrays.toString(myLottos.lottoNumbersToArray(i)));
        }

        List<Integer> winningNumbers = InputView.inputWinningNumbers();
        myLottos.matchingNumbers(winningNumbers);

        WinningMoney winningMoney = new WinningMoney();

        for (int i = 3; i <= 6; i++){
            System.out.println(i + "개 일치 (" + winningMoney.winningMoneyOf(i) + ") - " + myLottos.returnMatchCountOf(i) + "개");
        }

        System.out.println("총 수익률은 " + myLottos.returnRate(payMoney) + "입니다.");
    }
}
