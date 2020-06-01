package lotto;

import lotto.domain.generator.LottoNumberGenerator;
import lotto.domain.lotto.LottoRank;
import lotto.domain.lotto.LottoTicket;
import lotto.domain.lotto.Price;
import lotto.domain.number.LottoNumber;
import lotto.domain.winning.WinningLotto;
import lotto.domain.winning.WinningStatistics;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int inputPrice = InputView.printRequirePrice();
        Price price = new Price(inputPrice);

        LottoTicket lottoTicket = new LottoTicket(price, new LottoNumberGenerator());

        OutputView.printPurchasedLottoTicket(lottoTicket);

        String winningNumbers = InputView.printRequireWinningNumbers();
        int bonusNumber = InputView.printRequireBonusBall();

        Map<LottoRank, Long> lottoRank = lottoTicket.matchWinningNumber(new WinningLotto(winningNumbers),
                new LottoNumber(bonusNumber));

        OutputView.printStatistics(new WinningStatistics(price, lottoRank));
    }
}
