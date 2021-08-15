package View;


import Lotto.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static Lotto.Money.MONEY_DIVIDE_REMAINDER_ZERO;

public class ResultView {


    public static void printLottoResult(List<Lotto> dynamicLottos, List<Lotto> passiveLotto) {


        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다..\n", passiveLotto.size(), dynamicLottos.size());

        List<Lotto> lottos = LottoMachine.combineLotto(dynamicLottos, passiveLotto);

        lottos.forEach(s -> System.out.println(s.getLottoNumbers()));

        int bonusBall = InputView.insertBonusNumber();

        LotterNumbers winningNumber = LotterNumbers.of(WinningNumber.of(InputView.insertLastWeekWinningNumber()).getWinningNumbers());

        List<WinningPrice> winningPrice = IntStream.range(MONEY_DIVIDE_REMAINDER_ZERO, lottos.size())
                .mapToObj(i -> WinningPrice.getWinnings(lottos.get(i).compareNumbers(winningNumber.getLottoNumbers()), lottos.get(i).getLottoNumbers().contains(bonusBall)))
                .collect(Collectors.toList());

        System.out.println(WinningResult.of(winningPrice).getWinningResult().toString());
        System.out.println("총 수익률은 " + WinningResult.of(winningPrice).yieldAccount(lottos.size() * 1000) + "입니다.");

    }

}
