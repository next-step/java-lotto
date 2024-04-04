package lottopackage.controller;

import lottopackage.domain.LottoGroup;
import lottopackage.domain.Prize;
import lottopackage.view.InputView;
import lottopackage.view.OutputView;

import java.util.List;

public class LottoMachine {
    InputView inputView;
    OutputView outputView;

    public LottoMachine() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public int numOfLotto() {
        int purchaseAmount = inputView.purchaseAmount();
        if (purchaseAmount < 1000) {
            throw new IllegalArgumentException("로또 한 장은 1000원입니다.");
        }
        int numOfLotto = (int)(purchaseAmount / 1000);
        System.out.println(numOfLotto + "개를 구매했습니다.");
        return numOfLotto;
    }

    public void lottoMachine() {
        int numOfLotto = numOfLotto();
        LottoGroup lottoGroup = new LottoGroup(numOfLotto);
        outputView.printLottoGroup(lottoGroup.getLottoGroup());
        List<Integer> winningNumber = inputView.winningNumber();
        List<Prize> lottoResult = lottoGroup.isWinning(winningNumber);

        outputView.printLottoResult(lottoResult, lottoGroup.getLottoGroup().size());
    }
}
