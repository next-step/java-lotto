package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoGroup;
import lotto.domain.Rank;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.List;

public class LottoGame {
    public void start() {
        // TODO: input money
        LottoGroup lottoGroup = new LottoGroup(14);
        ResultView.printLottoGroup(lottoGroup);
        String winningLottoNumbers = InputView.getWinningLotto();
        Lotto winningLotto = new Lotto(winningLottoNumbers);
        int bonusNo = InputView.getBonusNo();
        // TODO: 결과 출력
        List<Rank> ranks = lottoGroup.matching(winningLotto);
        // TODO: 수익률 계산
    }
}
