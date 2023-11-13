package lotto.controller;

import lotto.domain.InputValidator;
import lotto.domain.LottoFactory;
import lotto.domain.Lottos;
import lotto.ui.InputView;
import lotto.ui.OutputView;

import static lotto.constant.Constant.PRICE_UNIT;

public class LottoMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        int price = inputView.inputPrice();
        InputValidator inputValidator = new InputValidator();
        inputValidator.validatePurchasePrice(price);

        int lottoCount = price / PRICE_UNIT;
        LottoFactory lottoFactory = new LottoFactory();
        Lottos lottos = lottoFactory.generateLottos(lottoCount);

        OutputView outputView = new OutputView();
        outputView.printLottos(lottoCount, lottos);
    }
}
