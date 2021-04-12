package lotto;

import lotto.domain.LottoStore;
import lotto.domain.LottoTicket;
import lotto.domain.LottoWiningNumbers;
import lotto.domain.place.LottoPlaces;
import lotto.function.SixLottoNumbers;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

  public static void main(String[] args) {
    LottoTicket boughtLottoTicket = LottoTicket.toBuy(InputView.buyLotto(), new SixLottoNumbers());
    InputView.printBoughtLottoNumbers(boughtLottoTicket);

    String lottoWiningNumbersString = InputView.writeLottoWiningNumbersString();
    LottoWiningNumbers lottoWiningNumbers = LottoWiningNumbers.generate(lottoWiningNumbersString);
    int lottoBonusBallNumber = 0;
    LottoStore store = LottoStore.open(lottoWiningNumbers, lottoBonusBallNumber)
            .exchange(boughtLottoTicket);

    long totalWinMoney = store.totalWinMoney();
    long returnOnInvestment = totalWinMoney / boughtLottoTicket.totalMoneySpent();

    LottoPlaces places = store.getLottoPlaces();

    ResultView.print(places, returnOnInvestment);
  }
}
