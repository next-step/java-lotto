package lotto;

import lotto.policy.DefaultLottoNumberGeneratePolicy;

import java.util.*;
import java.util.stream.Collectors;

public class LottoApplication {
    public static void main(String[] args) {
        int purchaseAmount = InputView.getPurchaseAmount();
        LottoGame lottoGame = new LottoGame(purchaseAmount, new DefaultLottoNumberGeneratePolicy());
        OutputView.printLottoTickets(lottoGame.getLottoTickets());
        Set<Integer> winners = Arrays.stream(InputView.getLastWeekWinningNumber().split(", "))
                                      .mapToInt(Integer::parseInt)
                                      .boxed()
                                      .collect(Collectors.toSet());
        lottoGame.getLottoTickets().calculateLottoStatistics(winners);
        OutputView.printLottoStatistics(lottoGame.getLottoTickets().getLottoStatistics());
        OutputView.printRateOfReturn(purchaseAmount, lottoGame);
    }
}
