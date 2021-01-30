package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Map;

public class LottoGame {

    public static void main(String[] args) {
        int money = InputView.getLottoMoney(); // 구입 금액을 입력해주세요
        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> lottos = lottoMachine.start(money);
        ResultView.printPurchaseNumber(lottos.size()); // 개를 구입했습니다.

//        ResultView.printGenerateLottos(lottos); // Lotto 목록 출력

        List<Integer> winningLottoNumbers = InputView.getWinningNumbers(); // 당첨 번호를 입력해주세요

        int bonusBall = InputView.getBonusBall(); // 보너스 볼을 입력해 주세요.

        Lotto test = new Lotto(winningLottoNumbers);
        WinningLotto winningLotto = WinningLotto.generate(test, bonusBall);

        Map<WinningType, Integer> matchResult = LottoCalculation.result(winningLotto, lottos); // 로또 결과 계산
        for(WinningType key : matchResult.keySet() ){
            Integer value = matchResult.get((key));
            System.out.println( String.format("키 : "+key+", 값 : "+value));
        }

        ResultView.printResult(matchResult, money); // 로또 결과 출력
    }
}
