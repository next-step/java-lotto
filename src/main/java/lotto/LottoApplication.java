package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {

        // 구입급액 입력 받기
        long purchaseAmount = InputView.getInputAmount();

        // 로또 구매
        LottoShop lottoShop = new LottoShop(1000);
        LottoGenerator lottoGenerator = new AutoLottoGenerator();
        LottoTickets lottoTickets = lottoShop.buy(purchaseAmount, lottoGenerator);

        // 내가 산 로또 출력
        ResultView.showBuyLottoTickets(lottoTickets);

        // 당첨 번호 입력
        List<Integer> winningNumbers = InputView.getWinningNumber();

        // 로또 매칭
        LottoStatistic lottoStatistic = lottoTickets.matching(winningNumbers);

        // 당첨 통계
        ResultView.showLottoResult(lottoStatistic, purchaseAmount);
    }
}
