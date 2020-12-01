package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoSimulator {

    private static final int LOTTO_GAME_PRICE = 1000;

    private LottoNumberGenerator numberGenerator;
    private List<LottoGame> boughtLottoGames;
    private int cost;

    public LottoSimulator(LottoNumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public List<LottoGame> buy(int cost) {
        this.cost = cost;
        this.boughtLottoGames = new ArrayList<>();

        int numGames = cost / LOTTO_GAME_PRICE;
        for (int i = 0; i < numGames; i++) {
            boughtLottoGames.add(new LottoGame(numberGenerator.generate()));
        }

        return boughtLottoGames;
    }

    public LottoResult getWinnerResult(List<Integer> winningNumbers) {
        LottoGame.validateNumbers(winningNumbers);

        LottoResult lottoResult = new LottoResult(cost);

        for (LottoGame lottoGame : boughtLottoGames) {
            LottoPlace place = lottoGame.getMatchedPlace(winningNumbers);

            lottoResult.addPlace(place);
        }

        return lottoResult;
    }

}
