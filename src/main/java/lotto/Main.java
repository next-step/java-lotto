package lotto;

import lotto.domain.LottoService;

public class Main {
    public static void main(String[] args) {
        LottoService lottoService = new LottoService();
        lottoService.purchase();
    }
}
