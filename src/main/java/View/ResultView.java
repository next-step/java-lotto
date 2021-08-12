package View;


import Lotto.Lotto;
import Lotto.WinningNumber;
import Lotto.WinningPrice;
import Lotto.WinningResult;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static Lotto.Money.MONEY_DIVIDE_REMAINDER_ZERO;

public class ResultView {


    public static void printLottoResult(List<Lotto> lottos) {

        lottos.forEach(s -> System.out.println(s.getLottoNumbers()));

        WinningNumber winningNumber = WinningNumber.of(InputView.insertLastWeekWinningNumber().split(","));

        List<WinningPrice> winningPrice = IntStream.range(MONEY_DIVIDE_REMAINDER_ZERO, lottos.size())
                .mapToObj(i -> WinningPrice.getWinnings(lottos.get(i).compareNumbers(List.of(winningNumber.convertInteger()))))
                .collect(Collectors.toList());

        System.out.println(WinningResult.of(winningPrice).getWinningResult().toString());
        System.out.println("총 수익률은 " + WinningResult.of(winningPrice).yieldAccount(lottos.size() * 1000) + "입니다.");

    }

}
