package lotto.view;

import lotto.domain.LottoShop;

public class LottoGamesView {
    private final LottoShop lottoShop;

    public LottoGamesView(LottoShop lottoShop) {
        this.lottoShop = lottoShop;
    }

    public void printLottoGamesNumber() {
        System.out.println(lottoShop.getGameCount() + "개를 구매했습니다.");
        lottoShop.getLottoGames().forEach(lottoGame -> System.out.println(lottoGame.getNumbers()));
    }
}
