package step2.controller;

import java.util.HashMap;
import java.util.List;

import step2.domain.LottoNumberMatcher;
import step2.domain.MyLottoNumber;
import step2.view.InputView;
import step2.view.ResultView;

public class MainClass {
    private static final int DEFAULT_MONEY = 1000;

    public static void main(String[] args) {
        int ticketOfLotto = InputView.inputMoney();
        ResultView.printNumberOfLotto(ticketOfLotto);
        List<List<Integer>> lottoNumbers = MyLottoNumber.getMyLottoNumbers(MyLottoNumber.initLottoNumber(), ticketOfLotto);
        ResultView.printMyLottoNumber(lottoNumbers, ticketOfLotto);
        String[] winningLottoNumbers = InputView.getWinningLottoNumber();

        InputView.validateWinningLottoNumber(winningLottoNumbers);
        InputView.validateWinningLottoNumberSize(winningLottoNumbers);
        InputView.validateDuplicatedWinningLottoNumber(winningLottoNumbers);

        HashMap<Integer, Integer> hashMap = LottoNumberMatcher.getNumberMatch(winningLottoNumbers, lottoNumbers);

        ResultView.printWinningResult(hashMap);
        String lottoRateOfReturn = LottoNumberMatcher.getLottoRateOfReturn(ticketOfLotto * DEFAULT_MONEY);
        ResultView.printLottoRateOfReturn(lottoRateOfReturn);
    }
}
