package lotto.presentation;

import lotto.application.LottoService;
import lotto.domain.User;
import lotto.domain.WinningLotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoController {

    private final LottoService lottoService;
    private final InputView inputView;
    private final ResultView resultView;

    public LottoController(LottoService lottoService, InputView inputView, ResultView resultView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void startLotto() {
        int purchasePrice = inputView.inputPurchasePrice();
        User user  = lottoService.makeUser();
        user.purchaseLottos(purchasePrice);

        resultView.printPurchaseCount(lottoService.purchaseCount(user));
        resultView.printLottos(user.getLottos());

        List<Integer> numbers = parsingLottoNumbers(inputView.inputWinningLottoNumbers());
        int bonusNumber = inputView.inputWinningBonusNumber();
        WinningLotto winningLotto = lottoService.makeWinningLotto(numbers, bonusNumber);

        resultView.printLottoResult(user.getUserLottoResult(winningLotto));
    }

    private List<Integer> parsingLottoNumbers(String input) {
        return Arrays.stream(input.split(",\\s+")).map(Integer::parseInt).collect(Collectors.toList());
    }

}
