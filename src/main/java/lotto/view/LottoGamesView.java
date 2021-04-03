package lotto.view;

import lotto.domain.LottoShop;

public class LottoGamesView {
    private final LottoShop lottoShop;

    public LottoGamesView(LottoShop lottoShop) {
        this.lottoShop = lottoShop;
    }

    public void printLottoGamesNumber() {
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.\n",
                lottoShop.getManualGameCount(),
                lottoShop.getAutoGameCount());
        lottoShop.getLottoGames().forEach(lottoGame -> System.out.println(lottoGame.getNumbers()));
    }
}
