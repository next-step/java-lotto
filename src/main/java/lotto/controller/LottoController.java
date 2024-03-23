package lotto.controller;

import lotto.domain.Fee;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.view.InputView;

import java.util.List;

public class LottoController {

    private LottoGenerator lottoGenerator = new LottoGenerator();
    public void buyLotto() {
        /*
        지불 금액 = 인풋으로 받은 숫자
        로또<리스트> 로또 = 로또생성(지불금액)
        아웃풋.결과보여주기(로또)
        ----
        결과분석

         */
        Fee fee = InputView.payForGames();
        Lotto<List> lottos = lottoGenerator.generateLottos(fee);
    }
}
