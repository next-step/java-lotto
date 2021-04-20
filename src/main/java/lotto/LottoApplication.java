package lotto;

import lotto.domain.LottoBonusBall;
import lotto.domain.LottoTicket;
import lotto.domain.LottoWiningNumbers;
import lotto.domain.place.LottoPlaces;
import lotto.function.SixLottoNumbers;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoApplication {

  public static void main(String[] args) {
    int money = InputView.getMoneyOfBoughtLotto();
    int countOfBoughtManualLotto = InputView.getCountOfManualLotto();
    List<String> manualLottoNumberStringList = InputView.getManualLottoNumberStringList(countOfBoughtManualLotto);

    LottoTicket boughtLottoTicket = LottoTicket.toBuy(money,
            new SixLottoNumbers(),
            manualLottoNumberStringList);

    InputView.printBoughtLottoNumbers(boughtLottoTicket, countOfBoughtManualLotto);

    String lottoWiningNumbersString = InputView.getLottoWiningNumbersString();
    LottoWiningNumbers lottoWiningNumbers = LottoWiningNumbers.generate(lottoWiningNumbersString);

    int lottoBonusBallNumber = InputView.getBonusBall();

    LottoBonusBall bonusBall = LottoBonusBall.valueOf(lottoBonusBallNumber);
    LottoPlaces places = boughtLottoTicket.getMatchedLottoPlaces(lottoWiningNumbers, bonusBall);

    long percentOfInvestment = places.totalWinningMoney()
            / boughtLottoTicket.totalSpentMoney();
    ResultView.print(places, percentOfInvestment);
  }
}
