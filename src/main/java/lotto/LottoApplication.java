package lotto;

import lotto.domain.BonusBall;
import lotto.domain.LottoTicket;
import lotto.domain.WiningLottery;
import lotto.domain.place.Places;
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
    WiningLottery winingLottery = WiningLottery.generate(lottoWiningNumbersString);

    int lottoBonusBallNumber = InputView.getBonusBall();

    BonusBall bonusBall = BonusBall.valueOf(lottoBonusBallNumber);
    Places places = boughtLottoTicket.getMatchedPlaces(winingLottery, bonusBall);

    long percentOfInvestment = places.totalWinningMoney()
            / boughtLottoTicket.totalSpentMoney();
    ResultView.print(places, percentOfInvestment);
  }
}
