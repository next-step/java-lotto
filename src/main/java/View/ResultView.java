package View;


import Lotto.Lotto;
import Lotto.WinningNumber;
import Lotto.WinningPrice;
import Lotto.WinningResult;

import java.util.ArrayList;
import java.util.List;

public class ResultView {


    public static void printLottoResult(List<Lotto> lottos) {
        lottos.forEach(s -> System.out.println(s.getLottoNumbers()));


        WinningNumber winningNumber = WinningNumber.of(InputView.insertLastWeekWinningNumber().split(","));

        List<WinningPrice> winningPrice = new ArrayList<>();


        for (int i = 0; i < lottos.size(); i++) {
            winningPrice.add(WinningPrice.getWinnings(lottos.get(i).compareNumbers(List.of(winningNumber.convertInteger()))));
        }

        WinningResult winningResult = new WinningResult(winningPrice);
        System.out.println(winningResult.getWinningResult().toString());
        System.out.println("총 수익률은 " + winningResult.yieldAccount(lottos.size() * 1000) + "입니다.");

    }

}
