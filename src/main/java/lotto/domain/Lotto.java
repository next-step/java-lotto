package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private List<LottoGame> games;
    private int numberOfManualGames;
    private int numberOfGeneratedGames;

    public Lotto(int money, LottoNumberGenerator lottoNumberGenerator) {
        this(new PurchaseAmount(money), null, lottoNumberGenerator);
    }

    public Lotto(PurchaseAmount purchaseAmount, LottoNumberGenerator lottoNumberGenerator) {
        this(purchaseAmount, null, lottoNumberGenerator);
    }

    public Lotto(int money, List<String> manualLottoNumbers, LottoNumberGenerator lottoNumberGenerator) {
        this(new PurchaseAmount(money), manualLottoNumbers, lottoNumberGenerator);
    }

    public Lotto(PurchaseAmount purchaseAmount, List<String> manualLottoNumbers, LottoNumberGenerator lottoNumberGenerator) {
        if (manualLottoNumbers == null) {
            manualLottoNumbers = new ArrayList<>();
        }

        initLottoGame(purchaseAmount, manualLottoNumbers, lottoNumberGenerator);
    }

    public List<LottoGame> games() {
        return this.games;
    }

    public Winners winners(WinningNumber winningNumber) {
        Winners winners = new Winners();

        for (LottoGame game : games) {
            winners.increase(winningNumber.rank(game));
        }
        return winners;
    }

    public int numberOfGeneratedGames() {
        return numberOfGeneratedGames;
    }

    public int numberOfManualGames() {
        return numberOfManualGames;
    }

    private void initLottoGame(PurchaseAmount purchaseAmount, List<String> manualLottoNumbers, LottoNumberGenerator lottoNumberGenerator) {
        games = new ArrayList<>();

        appendManualGames(manualLottoNumbers);
        appendGeneratedGames(purchaseAmount, manualLottoNumbers.size(), lottoNumberGenerator);
    }

    private void appendManualGames(List<String> manualLottoNumbers) {
        List<LottoGame> manualLottoGame = manualLottoNumbers.stream()
                .map(LottoGame::new)
                .collect(Collectors.toList());

        numberOfManualGames = manualLottoGame.size();
        games.addAll(manualLottoGame);
    }

    private void appendGeneratedGames(PurchaseAmount purchaseAmount, int numberOfManualGames, LottoNumberGenerator lottoNumberGenerator) {
        numberOfGeneratedGames = numberOfGeneratedGames(purchaseAmount, numberOfManualGames);
        for (int i = 0; i < numberOfGeneratedGames; i++) {
            games.add(lottoNumberGenerator.numbers());
        }
    }

    private int numberOfGeneratedGames(PurchaseAmount purchaseAmount, int numberOfManualGames) {
        int numberOfGames = purchaseAmount.numberOfGames() - numberOfManualGames;
        if (numberOfGames < 0) {
            throw new IllegalArgumentException("구매 금액이 부족합니다.");
        }
        return numberOfGames;
    }
}
