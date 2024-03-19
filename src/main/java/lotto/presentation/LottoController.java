package lotto.presentation;

import lotto.application.LottoService;
import lotto.domain.Lotto;
import lotto.domain.User;

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

        List<Integer> numbers = parsingLottoNumbers(inputView.inputWinningLotto());
        Lotto winningLotto = lottoService.makeWinningLotto(numbers);

        resultView.printLottoResult(user.getUserLottoResult(winningLotto));
    }

    private List<Integer> parsingLottoNumbers(String input) {
        return Arrays.stream(input.split(",\\s+")).map(Integer::parseInt).collect(Collectors.toList());
    }

}
