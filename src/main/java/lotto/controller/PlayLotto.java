package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoStore;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class PlayLotto {
    public static void main(String[] args) {
        int money = InputView.inputMoney();
        InputView.removeLn();   //nextInt 찌꺼기 제거용

        int lotOfLotto = LottoStore.buyLotto(money);
        List<Lotto> lottoList;

        lottoList = LottoStore.pickUpLottos(lotOfLotto);

        ResultView.outputPickLotto(lottoList);

        String winnerNumber = InputView.inputWinnerNumber();

        int[] rankingResult = LottoStore.lottoResult(lottoList, winnerNumber);
        ResultView.outputLottoResult(rankingResult, money);
    }

}
