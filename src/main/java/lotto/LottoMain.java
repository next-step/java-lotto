package lotto;

import lotto.domain.*;
import lotto.domain.dto.LottoWinnersDto;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoMain {
    public static void main(String[] args) {
        int lottoPurchaseAmount = InputView.requestPurchaseAmount();
        int ticketNumber = lottoPurchaseAmount / 1000;

        LottoGame lottoGame = new LottoGame();
        Lottos lottos = lottoGame.purchase(ticketNumber);

        ResultView.printPurchaseLottos(lottos);
        lottoGame.drawLotto(getWinnerLotto());

        List<LottoWinnersDto> lottoWinnersDtos = createLottoWinnerDtos(lottoGame);
        ResultView.printWinners(lottoWinnersDtos);
        ResultView.printYield(lottoWinnersDtos, lottoPurchaseAmount);
    }

    private static Lotto getWinnerLotto() {
        Set<Integer> winnerNumbers = InputView.requestWinnerNumbers();
        return new Lotto(winnerNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toSet()));
    }

    private static List<LottoWinnersDto> createLottoWinnerDtos(LottoGame lottoGame) {
        return Arrays.stream(Award.values())
                .filter(award -> isBang(award))
                .map(award -> new LottoWinnersDto(award, lottoGame.countWinners(award)))
                .collect(Collectors.toList());
    }

    private static boolean isBang(Award award) {
        return !award.equals(Award.BANG) && !award.equals(Award.UNIDENTIFIED);
    }
}
