package step2;

import step2.service.LottoService;

public class LottoMain {
    public static void main(String[] args) {
        LottoService lottoService = new LottoService();
        lottoService.autoLotto();
    }
}
