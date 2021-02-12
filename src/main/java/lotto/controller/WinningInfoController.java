package lotto.controller;

import lotto.domain.LottoMachine;
import lotto.domain.LottoNumber;
import lotto.domain.WinningInfo;
import lotto.domain.WinningNumber;
import lotto.util.NumberUtils;
import lotto.view.ErrorView;
import lotto.view.RequestView;

public class WinningInfoController {

    private final RequestView requestView;
    private final ErrorView errorView;

    public WinningInfoController(RequestView requestView, ErrorView errorView) {
        this.requestView = requestView;
        this.errorView = errorView;
    }

    public WinningInfo requestWinningNumberAndBonus() {
        WinningNumber winningNumber = requestWinningNumber();
        LottoNumber bonusNumber = requestBonusNumber();
        return new WinningInfo(winningNumber, bonusNumber);
    }

    private WinningNumber requestWinningNumber() {
        try {
            String winningNumberInput = requestView.requestWinningNumber();
            return new WinningNumber(
                new LottoMachine()
                    .generateManualTicket(winningNumberInput)
            );
        } catch (IllegalArgumentException e) {
            errorView.printErrorWinningNumber();
            return requestWinningNumber();
        }
    }

    private LottoNumber requestBonusNumber() {
        try {
            String bonus = requestView.requestBonusNumber();
            return new LottoNumber(
                NumberUtils.returnInteger(bonus)
            );
        } catch (IllegalArgumentException e) {
            errorView.printErrorBonusBall();
            return requestBonusNumber();
        }
    }
}
