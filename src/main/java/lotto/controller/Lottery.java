package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.Number;
import lotto.domain.factory.LottoFactory;
import lotto.domain.lotto.Lotto;
import lotto.view.InputInfo;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class Lottery {

    public void draw() {
        Number price = Number.of(InputView.questionPrice());
        Number manualCount = Number.of(InputView.questionManualCount());

        // 입력 정보
        InputInfo inputInfo = new InputInfo(price, manualCount);
        List<String> inputManualLottos = InputView.questionManualInput(inputInfo.getManualCount());

        // 수동 로또 생성
        List<Lotto> manualLottos = LottoFactory.manualLottos(inputManualLottos);
        Lottos lottos = new Lottos(manualLottos);

        // 자동 로또 추가
        List<Lotto> autoLottos = LottoFactory.autoLottos(inputInfo.getAutoCount());
        lottos.addLottos(autoLottos);

        // 입력 정보 받기
        inputInfo.printInfo();

        ResultView.printLottos(lottos);

        winner(lottos);
    }



    private void winner(Lottos lottos) {
        String answerText = InputView.questionAnswer();
        String bonusBall = InputView.questionBonus();
        Number bonus = Number.of(bonusBall);
        Lotto answer = LottoFactory.newInstance(answerText);
        ResultView resultView = new ResultView(lottos, answer, bonus);
        resultView.printResult();
    }

}
