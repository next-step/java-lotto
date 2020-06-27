package lotto;

import lotto.domain.*;
import lotto.view.Input;
import lotto.view.Output;

import java.util.List;

public class LottoMain {

    public static void main(String[] args) {

        Money money = Input.inputMoney();

        LottoGame lottoGame = new LottoGame(money, Input.inputSelectLottoCount());

        List<Lotto> selectLottos = Input.inputSelectLottonumber(lottoGame);
        Output.printAutoCountSelectCount(lottoGame);

        LottoController lottoController = new LottoController(lottoGame, selectLottos);
        lottoController.createLotto();

        WinningLotto winningLotto = Input.inputLastWinningNumber();
        WinningLottoResult lottoResult = lottoController.matchLotto(winningLotto);

        Output.printResultStatic(lottoResult, lottoGame);

    }
}
