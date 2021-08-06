package lottos.controller;

import lottos.domain.Lotto;
import lottos.domain.LottoGame;
import lottos.domain.Lottos;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoConsoleController {

    public Lottos buy(int purchaseAmount, int amountPerPiece) {
        LottoGame lottoGame = new LottoGame();
        return lottoGame.start(purchaseAmount, amountPerPiece);
    }

    public Lotto lastWeeksWinningLotto(String lastWeeksNumberText) {
        List<Integer> numbers = Arrays.stream(lastWeeksNumberText.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return new Lotto(numbers);
    }
}
