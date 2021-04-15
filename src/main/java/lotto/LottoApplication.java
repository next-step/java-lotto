package lotto;

import lotto.domain.LottoBonusBall;
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

    int lottoBonusBallNumber = InputView.writeBonusBall();

    LottoBonusBall bonusBall = LottoBonusBall.valueOf(lottoBonusBallNumber);
    LottoPlaces places = boughtLottoTicket.getMatchedLottoPlaces(lottoWiningNumbers, bonusBall);

    long percentOfInvestment = places.totalWinningMoney()
            / boughtLottoTicket.totalSpentMoney();
    ResultView.print(places, percentOfInvestment);
  }
}
