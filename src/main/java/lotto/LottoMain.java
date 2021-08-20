package lotto;

import lotto.domain.*;
import lotto.domain.dto.LottoWinnersDto;
import lotto.util.LottoGenerator;
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

        int manualTicketNumber = InputView.requestManualTicket();
        List<Set<Integer>> manualLottoNumbers = InputView.requestManualNumbers(manualTicketNumber);
        List<Lotto> lottoList = LottoGenerator.createLottos(manualLottoNumbers, ticketNumber);

        Lottos lottos = new Lottos(lottoList);
        ResultView.printLottos(lottos);

        Map<Award, Long> lottoDrawResult = lottos.drawLottos(getWinnerLotto());
        LottoResult lottoResult = new LottoResult(lottoDrawResult);
        List<LottoWinnersDto> lottoWinnersDtos = lottoResult.createLottoWinnerDtos();
        Yield yield = lottoResult.calculateYield(lottoPurchaseAmount);

        ResultView.printWinners(lottoWinnersDtos);
        ResultView.printYield(yield);
    }

    private static WinnerLotto getWinnerLotto() {
        Set<Integer> winnerNumbers = InputView.requestWinnerNumbers();
        Lotto lotto = new Lotto(winnerNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toSet()));
        int bonusNumber = InputView.requestBonusNumber();
        LottoNumber bonusLottoNumber = new LottoNumber(bonusNumber);
        return new WinnerLotto(lotto, bonusLottoNumber);
    }

}
