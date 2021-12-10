package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.Number;
import lotto.domain.factory.LottoAnswerFactory;
import lotto.domain.lotto.Lotto;
import lotto.view.InputInfo;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;

public class Lottery {

    public void draw() {
        Number price = Number.of(InputView.questionPrice());
        Number manualCount = Number.of(InputView.questionManualCount());

        // 입력 정보
        InputInfo inputInfo = new InputInfo(price, manualCount);
        List<String> inputManualLottos = InputView.questionManualInput(inputInfo.getManualCount());

        // 수동 로또 생성
        List<Lotto> manualLottos = getLottos(inputManualLottos);
        Lottos lottos = new Lottos(manualLottos);

        // 자동 로또 추가
        lottos.addAutoLottos(inputInfo.getAutoCount());

        // 입력 정보 받기
        inputInfo.printInfo();

        ResultView.printLottos(lottos);

        winner(lottos);
    }

    private List<Lotto> getLottos(List<String> inputManualLottos) {
        LottoAnswerFactory factory = new LottoAnswerFactory();
        List<Lotto> manualLottos = inputManualLottos.stream()
                .map(factory::newInstance)
                .collect(Collectors.toList());
        return manualLottos;
    }

    private void winner(Lottos lottos) {
        String answerText = InputView.questionAnswer();
        String bonusBall = InputView.questionBonus();
        Number bonus = Number.of(bonusBall);
        LottoAnswerFactory factory = new LottoAnswerFactory();
        Lotto answer = factory.newInstance(answerText);
        ResultView resultView = new ResultView(lottos, answer, bonus);
        resultView.printResult();
    }

}
