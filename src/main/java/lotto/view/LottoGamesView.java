package lotto.view;

import lotto.domain.LottoGames;

public class LottoGamesView {
    private final LottoGames lottoGames;

    public LottoGamesView(LottoGames lottoGames) {
        this.lottoGames = lottoGames;
    }

    public void printLottoGamesNumber() {
        System.out.println(lottoGames.getGameCount() + "개를 구매했습니다.");
        lottoGames.getLottoGames().forEach(lottoGame -> System.out.println(lottoGame.getNumbers()));
    }
}
