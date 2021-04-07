package lotto.view;

import lotto.domain.LottoShop;

public class LottoGamesView {
    private final LottoShop lottoShop;
    private final int manualGameCount;
    private final int autoGameCount;

    public LottoGamesView(LottoShop lottoShop, int manualGameCount, int autoGameCount) {
        this.lottoShop = lottoShop;
        this.manualGameCount = manualGameCount;
        this.autoGameCount = autoGameCount;
    }

    public void printLottoGamesNumber() {
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.\n",
                manualGameCount,
                autoGameCount);
        lottoShop.getLottoGames().forEach(lottoGame -> System.out.println(lottoGame.getNumbers()));
    }
}
