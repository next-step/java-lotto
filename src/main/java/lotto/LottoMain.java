package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.LottoNumber;
import lotto.domain.WinnerLotto;
import lotto.domain.dto.LottoDrawResult;
import lotto.domain.dto.LottoPurchaseResult;
import lotto.domain.dto.LottoWinnersDto;
import lotto.util.LottoListGenerator;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoMain {
    public static void main(String[] args) {
        int lottoPurchaseAmount = InputView.requestPurchaseAmount();
        int ticketNumber = lottoPurchaseAmount / 1000;

        LottoGame lottoGame = new LottoGame();
        LottoPurchaseResult lottoPurchaseResponse = lottoGame.purchase(LottoListGenerator.creatLottos(ticketNumber));
        ResultView.printPurchaseLottos(lottoPurchaseResponse);

        LottoDrawResult lottoResult = lottoGame.drawLotto(getWinnerLotto());
        List<LottoWinnersDto> lottoWinnersDtos = lottoResult.createLottoWinnerDtos();
        double yield = lottoResult.calculateYield(lottoPurchaseAmount);

        ResultView.printWinners(lottoWinnersDtos);
        ResultView.printYield(yield);
    }

    private static WinnerLotto getWinnerLotto() {
        Set<Integer> winnerNumbers = InputView.requestWinnerNumbers();
        Lotto lotto = new Lotto(winnerNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toSet()));
        Integer bonusNumber = InputView.requestBonusNumber();
        LottoNumber bonusLottoNumber = new LottoNumber(bonusNumber);
        return new WinnerLotto(lotto, bonusLottoNumber);
    }

}
