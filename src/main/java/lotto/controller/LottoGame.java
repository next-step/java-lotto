package lotto.controller;

import lotto.domain.LottoTicket;
import lotto.domain.LottoWinning;
import lotto.domain.Rank;
import lotto.domain.Store;
import lotto.domain.value.OrderPrice;
import lotto.view.InsertView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Map;

public class LottoGame {

    public void start() {

        String inputMoney = InsertView.printInputIntro();
        OrderPrice lottoPrice = new OrderPrice(inputMoney);

        String manualInput = InsertView.printManualInput();
        List<String> manualNumbers = InsertView.printInputLottoNumbers(Integer.parseInt(manualInput));

        Store store = new Store();
        LottoTicket lottoTicket = store.purchaseTicket(lottoPrice, manualNumbers);

        int autoLottoSize = lottoTicket.getLotto().size();
        int manualLottoSize = manualNumbers.size();
        ResultView.printOrderCount(manualLottoSize, autoLottoSize);
        ResultView.printOrderLottoNumber(lottoTicket);

        LottoWinning lottoWinning = LottoWinning.from(InsertView.printInputWinningNumbers(),
                InsertView.printInputBonusNumber());
        Map<Rank, Integer> prizeWinnersRepository = lottoWinning.createRepository(lottoTicket);

        ResultView.printWinningStatics(prizeWinnersRepository);
        ResultView.printRateOfReturn(lottoWinning.calculateRateOfProfit(prizeWinnersRepository, lottoPrice.getLottoPrice()));
    }
}
