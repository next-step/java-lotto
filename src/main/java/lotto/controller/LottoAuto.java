package lotto.controller;

import lotto.model.LottoRules;
import lotto.model.User;
import lotto.model.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoAuto {
    private static LottoAuto lottoAuto = new LottoAuto();
    private LottoAuto(){
    }
    public static LottoAuto getInstance(){
        return lottoAuto;
    }
    public void play() {
        LottoRules lottoRules = new LottoRules();
        User user = new User(OutputView.getLottoCount(InputView.getPrice() / lottoRules.getLottoPrice()),
            lottoRules);
        OutputView.printLottos(user.getLottos());
        WinningNumber winningNumber = new WinningNumber(InputView.getWinningNumber(), lottoRules);
        winningNumber.setBonusBall(InputView.getBonusBall());
        user.setRanks(winningNumber);
        OutputView.printResult(user.getRanks(), user.getCount() * lottoRules.getLottoPrice());
    }
}
