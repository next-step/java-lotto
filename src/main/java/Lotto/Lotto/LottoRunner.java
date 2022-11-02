package Lotto.Lotto;

import Lotto.View.InputView;
import Lotto.View.OutputView;

public class LottoRunner {
    public static void main(String[] args) {
        // 로또 구매
        LottoMoney lottoMoney = InputView.inputMoney();
        LottoTickets lottoTickets = new LottoTickets(lottoMoney);

        // 구매한 로또 출력
        OutputView.printTickets(lottoTickets);

        // 우승 번호
        LottoWinNumbers lottoWinNumbers = InputView.inputWinNumbers();

        // 결과 출력
        LottoResult lottoResult = new LottoResult(lottoMoney, lottoTickets, lottoWinNumbers);
        OutputView.printResult(lottoResult);
    }
}
