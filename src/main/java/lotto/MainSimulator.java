package lotto;

import lotto.controller.LottoController;
import lotto.domain.Lottoes;
import lotto.dto.LottoGameResultDto;

public class MainSimulator {

    private static final LottoController lottoController = new LottoController();

    public static void main(String[] args) {
        Lottoes lottoes = lottoController.purchaseLottoes();
        lottoController.getLottoGameResult(lottoes);
    }
}
