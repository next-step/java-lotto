package study.lotto;

import study.lotto.controller.LottoStore;
import study.lotto.domain.LottoNumber;
import study.lotto.domain.LottoResult;
import study.lotto.service.Lottos;
import study.lotto.view.ResultView;
import study.lotto.view.dto.RequestMoney;
import study.lotto.view.dto.RequestWinningNumber;

import static study.lotto.view.InputView.*;
import static study.lotto.view.ResultView.*;


public class LottoApplication {
    public static void main(String[] args) {
        LottoStore lottoStore = new LottoStore();

        // 금액 요청
        RequestMoney requestMoney = money();
        ResultView.printLottoCount(requestMoney);
        Lottos lottos = lottoStore.lotto(requestMoney);

        // 중간 보기
        ResultView.printLottos(lottos);

        // 당첨 번호 입력
        RequestWinningNumber winningNumber = winningNumber();
        LottoNumber bonusNumber = bonusNumber();
        LottoResult lottoResult = new LottoResult(winningNumber, lottos, bonusNumber);
        // 결과 보기
        printResult(lottoResult);
        printRate(lottoResult);
    }
}
