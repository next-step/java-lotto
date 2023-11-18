package step2;

import java.util.List;

public class LottoGameController {

    private final LottoGenerator lottoGenerator = new LottoGenerator();

    public void game() {
        int userInput = 2000;
        Money money = new Money(userInput);
        String userWinningInput = "1, 2, 3, 4, 5, 6";
        Lottos lottos = new Lottos(lottoGenerator.generateLottos(money.determineLottoPurchaseCount()));
        Lotto winningLotto = lottoGenerator.generateWinningLotto(userWinningInput);
        LottoResult lottoResult = new LottoResult(lottos.calculateTotalRank(winningLotto));
    }
}
