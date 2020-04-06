package lotto.Controller;


import lotto.Domain.*;
import lotto.View.InputView;
import lotto.View.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoController {

    InputView inputView;
    OutputView outputView;
    Buyer buyer;

    public LottoController(InputView inputView, Buyer buyer) {
        this.inputView = inputView;
        this.outputView = OutputView.init();
        this.buyer = buyer;
    }

    public void purchaseLotto() {
        int price = inputView.userInstructionAmount();
        int count = buyer.payToLotto(price);

        List<String> manualLottoNumbers = inputView.userInstructionManually();
        Lottos lottos = buyer.purchaseManualLotto(manualLottoNumbers);

        lottos = buyer.purchaseAutoLotto(lottos, (count - lottos.toList().size()));

        outputView.userInstructionCount(manualLottoNumbers.size(), (lottos.toList().size() - manualLottoNumbers.size()));
        outputView.boughtLottoList(lottos);

        String winnerLottoNumbers = inputView.userInstructionWinner();
        int bonus = inputView.userInstructionBonus();
        WinningLotto winningLotto = buyer.winningLottoNumbers(winnerList(winnerLottoNumbers), bonus);

        LottoResult lottoResult = lottos.match(winningLotto);

        outputView.LottoResult(lottoResult);

    }

    private List<Integer> winnerList(String winnerLottoNumbers) {
        return Arrays.stream(winnerLottoNumbers.split(", "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }
}