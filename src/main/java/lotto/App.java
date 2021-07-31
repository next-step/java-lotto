package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class App {

    public static void main(String[] args) {
        Lottos buyTickets = buyAutoTicket();
        Lottos buyManualTickets = buyManualTicket();
        buyManualTickets.concat(buyTickets);

        ResultView.printBuyTicket(buyManualTickets, buyTickets);

        LottoNumbers winTicket = getWinTicket();
        LottoNumber bonusNumber = getBonusNumber();

        ResultView.printStatistics(buyManualTickets, WinningLotto.of(winTicket, bonusNumber));
    }

    private static LottoNumbers getWinTicket() {
        return LottoNumbers.of(InputView.getInputWinNumbers());
    }

    private static LottoNumber getBonusNumber() {
        return LottoNumber.of(InputView.getInputBonusNumber());
    }

    private static Lottos buyAutoTicket() {
        return Lottos.of(InputView.getInputBuyMoney());
    }

    private static Lottos buyManualTicket() {
        int buyCount = InputView.getManualTicket();
        InputView.printManualNumbers();
        List<LottoNumbers> lottoNumbers = new ArrayList<>();
        IntStream.range(0, buyCount)
                .forEach(s -> lottoNumbers.add(LottoNumbers.of(InputView.getNextLine())));

        return new Lottos(lottoNumbers);
    }
}
