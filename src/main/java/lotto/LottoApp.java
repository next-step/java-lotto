package lotto;

import lotto.biz.LottoService;

public class LottoApp {

    public static void main(String[] args) {
        LottoService service = new LottoService();
        service.setPurchaseValue();
        service.setWinningNumbers();
        service.getWinningStatistics();

    }
}
