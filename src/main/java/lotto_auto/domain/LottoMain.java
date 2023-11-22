package lotto_auto.domain;

import lotto_auto.io.InputView;
import lotto_auto.io.OutputView;

public class LottoMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        Lotto lotto = new Lotto(inputView.budget);
        lotto.getLottoNumber();
        OutputView outputView = new OutputView(lotto.lottoTotalNumberList);
        inputView.getMagicNumberComment();
        MagicNumber magicNumber = new MagicNumber(inputView.magicNumber, lotto.lottoTotalNumberList);
        magicNumber.compareMagicNumber();
        outputView.printStatistics(inputView.budget);

    }
}
