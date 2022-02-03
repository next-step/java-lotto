package lotto;

import java.util.List;
import lotto.domain.Analyzer;
import lotto.domain.LottoMachine;
import lotto.domain.LottoTickets;
import lotto.view.InputView;

public class LottoProcessor {

    static InputView inputView = new InputView();

    public static void main(String[] args) {
        int totalPrice = inputView.getTotalPrice();
        LottoTickets lottoTickets = new LottoTickets(totalPrice);

        int lottoCounts = lottoTickets.getLottoCounts();
        System.out.printf("%d개를 구매했습니다.%n", lottoCounts);

        List<Integer> winNumbers = inputView.getWinNumbers();
        int bonusNumber = inputView.getBonusNumber();

        LottoMachine lottoMachine = new LottoMachine(winNumbers, bonusNumber);
        List<Integer> integers = lottoTickets.countCorrectWinNumber(lottoMachine);
        List<Integer> bonusNumbers = lottoTickets.checkBonusNumber(lottoMachine);
        Analyzer analyzer = new Analyzer(totalPrice);
        analyzer.calculateWinningMoney(integers,bonusNumbers);
    }
}
