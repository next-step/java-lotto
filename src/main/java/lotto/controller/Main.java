package lotto.controller;

import java.util.List;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Main {

    public static void main(String[] args) {
        int money = InputView.getMoney();
        List<String> manualLottoNumbers = InputView.getManualLottos();

        LottoRequest request;
        try {
            request = new LottoRequest(money, manualLottoNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println("이 조건으로 로또를 구매할 수 없습니다. 사유 = " + e.getMessage());
            return;
        }

        LottoWallet lottoWallet;
        try {
            lottoWallet = request.buy();
        } catch (IllegalArgumentException e) {
            System.out.println("로또 구매에 실패했습니다. 사유 = " + e.getMessage());
            return;
        }

        OutputView.printLottoWallet(lottoWallet);

        String inputStr = InputView.getWinningNumbers();
        List<String> winningNumbers = List.of(inputStr.split(","));
        int bonusNumber = InputView.getBonusNumbers();

        LottoWinningNumber lottoWinningNumber;
        try {
            lottoWinningNumber = new LottoWinningNumber(new Lotto(winningNumbers), new LottoNumber(bonusNumber));
        } catch (IllegalArgumentException e) {
            System.out.println("당첨 번호 입력에 실패했습니다. 사유 = " + e.getMessage());
            return;
        }
        LottoResult lottoResult = lottoWallet.calculateResult(lottoWinningNumber);

        OutputView.printLottoResult(lottoResult);
    }
}
