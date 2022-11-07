package lotto.lotto;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoRunner {
    public static void main(String[] args) {
        // 로또 구매
        LottoMoney lottoMoney = InputView.inputMoney();
        LottoCount lottoCount = lottoMoney.getLottoCount();
        LottoTickets lottoTickets = new LottoTickets(lottoCount);
        OutputView.printTickets(lottoTickets);

        // 우승 번호와 당첨 결과 확인
        LottoWinNumbers lottoWinNumbers = InputView.inputWinNumbers();
        LottoResult lottoResult = LottoResult.of(lottoTickets, lottoWinNumbers);
        OutputView.printResult(lottoMoney, lottoResult);
    }
}
