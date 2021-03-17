package study.lotto;

import study.lotto.controller.LottoStore;
import study.lotto.domain.LottoResult;
import study.lotto.service.Lottos;
import study.lotto.view.dto.RequestMoney;
import study.lotto.view.dto.RequestWinningNumber;

import static study.lotto.view.InputView.requestMoney;
import static study.lotto.view.InputView.requestWinningNumber;
import static study.lotto.view.ResultView.*;


public class LottoApplication {
    public static void main(String[] args) {
        LottoStore lottoStore = new LottoStore();

        // 금액 요청
        RequestMoney requestMoney = requestMoney();
        printBuyCount(requestMoney);
        Lottos lottos = lottoStore.buyLotto(requestMoney);

        // 중간 보기
        printBuyLottos(lottos);

        // 당첨 번호 입력
        RequestWinningNumber winningNumber = requestWinningNumber();
        LottoResult lottoResult = new LottoResult(winningNumber, lottos);

        // 결과 보기
        printStatics(lottoResult);
        printRate(lottoResult);
    }
}
