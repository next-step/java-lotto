package lotto;

import lotto.view.InputView;

public class LottoApplication {
    public static void main(String[] args) {
        int purchaseAmount = InputView.purchaseAmount();


        LottoNumbers lottoNumbers = LottoMachine.generateLottoNumber();
        Lotto lotto = Lotto.from(lottoNumbers);
    }
}
