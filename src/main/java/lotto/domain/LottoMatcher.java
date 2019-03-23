package lotto.domain;

public class LottoMatcher {

    public static WinningResults calculateWinningResults(final LottoList lottos, final WinningLotto winningLotto) {
        WinningResults winningResults = new WinningResults();

        Prize[] prizes = Prize.values();
        for (int i = 0; i < prizes.length; i++) {
            winningResults.put(prizes[i],
                    new WinningResult(prizes[i], lottos.find(prizes[i], winningLotto)));
        }

        return winningResults;
    }
}
