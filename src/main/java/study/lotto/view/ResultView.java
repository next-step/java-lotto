package study.lotto.view;

import study.lotto.controller.LottoGame;
import study.lotto.domain.Lotto;
import study.lotto.service.Lottos;
import study.lotto.view.dto.RequestMoney;
import study.lotto.view.dto.RequestWinningNumber;

import java.util.List;

public class ResultView {

    public void printBuyCount(RequestMoney requestMoney) {
        System.out.println(requestMoney.getTotalLottoCount() + "개를 구매했습니다.");
    }

    public void printBuyLottos(Lottos lottos) {
        List<Lotto> lotteries = lottos.getLotteries();
        lotteries.forEach(System.out::println);
    }

    public void printStatics(RequestWinningNumber winningNumber, LottoGame lottoGame) {

    }
}
