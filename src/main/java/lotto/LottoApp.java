package lotto;

import lotto.service.LottoService;

public class LottoApp {

    public static void main(String[] args) {
        LottoService lottoService = new LottoService();
        lottoService.lottoGame();
    }
}
