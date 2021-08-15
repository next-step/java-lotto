package lotto;

import lotto.domain.*;
import lotto.domain.dto.LottoPurchaseResponse;
import lotto.domain.dto.LottoWinnersDto;
import lotto.util.LottoListGenerator;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoMain {
    public static void main(String[] args) {
        int lottoPurchaseAmount = InputView.requestPurchaseAmount();
        int ticketNumber = lottoPurchaseAmount / 1000;

        LottoGame lottoGame = new LottoGame();
        LottoPurchaseResponse lottoPurchaseResponse = lottoGame.purchase(LottoListGenerator.creatLottos(ticketNumber));
        ResultView.printPurchaseLottos(lottoPurchaseResponse);

        LottoDrawResponse lottoDrawResponse = lottoGame.drawLotto(getWinnerLotto());
        List<LottoWinnersDto> lottoWinnersDtos = createLottoWinnerDtos(lottoDrawResponse.getLottoResult());

        ResultView.printWinners(lottoWinnersDtos);
        ResultView.printYield(lottoWinnersDtos, lottoPurchaseAmount);
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

    private static List<LottoWinnersDto> createLottoWinnerDtos(Map<Award, Integer> lottoResult) {
        return lottoResult.entrySet().stream()
                .filter(e -> isNotBang(e.getKey()))
                .map(e -> new LottoWinnersDto(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }

    private static boolean isNotBang(Award award) {
        return !award.equals(Award.BANG) && !award.equals(Award.UNIDENTIFIED);
    }
}
